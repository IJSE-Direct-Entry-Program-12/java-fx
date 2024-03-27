package lk.ijse.dep12.fx.validation.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lk.ijse.dep12.fx.validation.Employee;

import java.util.ArrayList;

public class MainViewController {

    public Button btnNewEmployee;
    public Button btnSave;
    public ToggleGroup grpGender;
    public RadioButton rdFemale;
    public RadioButton rdMale;
    public TextField txtAddress;
    public TextField txtCountry;
    public TextField txtEmployeeId;
    public TextField txtName;
    public VBox vBox;

    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void initialize() {
        /* Set mnemonics */
        for (Node child : vBox.getChildren()) {
            HBox hBox = (HBox) child;
            for (int i = 0; i < hBox.getChildren().size(); i++) {
                //System.out.println(i + ": " + hBox.getChildren().get(i));
                if (hBox.getChildren().get(i) instanceof Label lbl) {
                    lbl.setLabelFor(hBox.getChildren().get(i + 1));
                }
            }
        }

        enableUI(false);
    }

    private void enableUI(boolean enable) {
        vBox.setDisable(!enable);
        btnSave.setDisable(!enable);
    }

    private String generateNewEmployeeId() {
        if (employeeList.isEmpty()) return "E001";

        /* The algo
            Employee lastEmployee = employeeList.get(employeeList.size() - 1);
            String lastEmployeeId = lastEmployee.getId();       // E125
            String lastEmployeeIdNumber = lastEmployeeId.replace("E", "");      // 125
            int newEmployeeId = Integer.parseInt(lastEmployeeIdNumber) + 1; // 126
         */

        int newId = Integer.parseInt(employeeList.get(employeeList.size() - 1).getId()
                .replace("E", "")) + 1;
        return "E%03d".formatted(newId);
    }

    public void btnNewEmployeeOnAction(ActionEvent event) {
        enableUI(true);
        txtEmployeeId.setText(generateNewEmployeeId());
        txtName.requestFocus();
    }

    public void btnSaveOnAction(ActionEvent event) {
        String name = txtName.getText().strip();
        String address = txtAddress.getText().strip();
        String country = txtCountry.getText().strip();
        boolean validate = true;
        for (Control control : new Control[]{rdMale, rdFemale, txtCountry, txtName, txtAddress}) {
            control.getStyleClass().remove("error");
        }

        /* Data Validation */
        if (grpGender.getSelectedToggle() == null) {
            rdMale.getStyleClass().add("error");
            rdFemale.getStyleClass().add("error");
            rdMale.requestFocus();
            validate = false;
        }
        if (country.isEmpty()) {
            txtCountry.requestFocus();
            txtCountry.getStyleClass().add("error");
            validate = false;
        }
        if (address.isEmpty()) {
            txtAddress.requestFocus();
            txtAddress.getStyleClass().add("error");
            validate = false;
        }
        if (name.isEmpty()) {
            txtName.requestFocus();
            txtName.getStyleClass().add("error");
            validate = false;
        }

        if (!validate) return;

        Employee employee = new Employee(txtEmployeeId.getText(),
                name,
                address,
                country,
                ((RadioButton) grpGender.getSelectedToggle()).getText());
        employeeList.add(employee);

        for (TextField txt : new TextField[]{txtEmployeeId, txtName, txtAddress, txtCountry}) {
            txt.clear();
        }
        grpGender.selectToggle(null);
        enableUI(false);
    }

}
