package lk.ijse.dep12.fx.validation.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import lk.ijse.dep12.fx.validation.Client;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class MainViewController {

    public Button btnNewClient;
    public Button btnSave;
    public CheckBox chkCarVan;
    public CheckBox chkHouse;
    public CheckBox chkLand;
    public CheckBox chkMotorBike;
    public HBox genderWrapper;
    public ToggleGroup grpGender;
    public GridPane propertyWrapper;
    public RadioButton rdFemale;
    public RadioButton rdMale;
    public AnchorPane root;
    public TextField txtAddress;
    public DatePicker txtDob;
    public TextField txtId;
    public TextField txtName;
    public GridPane container;
    public TextField txtNic;

    private ArrayList<Client> clientList = new ArrayList<>();

    public void initialize() {
        for (Node node : container.lookupAll(".label")) {
            Label lbl = (Label) node;
            lbl.setLabelFor(container.lookup(lbl.getAccessibleText()));
        }
        container.setDisable(true);
    }

    public void btnNewClientOnAction(ActionEvent event) {
        txtId.setText(generateNewClientId());
        container.setDisable(false);
        txtNic.requestFocus();
    }

    private String generateNewClientId() {
        if (clientList.isEmpty()) return "C-0001";
        int newId  = Integer.parseInt(clientList.get(clientList.size() - 1).getId().replace("C-", ""))+1;
        return "C-%04d".formatted(newId);
    }

    public void btnSaveOnAction(ActionEvent event) {
        boolean valid = true;
        for (Node node : container.lookupAll(".error")) {
            node.getStyleClass().remove("error");
        }

        boolean property = false;
        for (Node child : propertyWrapper.getChildren()) {
            CheckBox chk = (CheckBox) child;
            if (chk.isSelected()) {
                property = true;
                break;
            }
        }
        if (!property) {
            propertyWrapper.getStyleClass().add("error");
            chkLand.requestFocus();
            valid = false;
        }

        if (txtDob.getValue() == null ||
                Period.between(txtDob.getValue(), LocalDate.now()).getYears() < 18) {
            txtDob.getStyleClass().add("error");
            txtDob.requestFocus();
            valid = false;
        }

        if (grpGender.getSelectedToggle() == null){
            rdMale.requestFocus();
            valid = false;
            genderWrapper.getStyleClass().add("error");
        }

        String address = txtAddress.getText();
        if (!address.isEmpty()){
            if (address.isBlank() || address.strip().length() < 4){
                valid = false;
                txtAddress.requestFocus();
                txtAddress.getStyleClass().add("error");
            }
        }

        String name = txtName.getText().strip();
        if (name.isBlank() || !isValidName(name)){
            valid = false;
            txtName.requestFocus();
            txtName.getStyleClass().add("error");
        }

        String nic = txtNic.getText().strip();
        if (nic.isBlank() || !isValidNic(nic)){
            valid = false;
            txtNic.requestFocus();
            txtNic.getStyleClass().add("error");
        }

        if (!valid) return;

        ArrayList<String> properties = new ArrayList<>();

        for (Node child : propertyWrapper.getChildren()) {
            CheckBox chk = (CheckBox) child;
            if (chk.isSelected()) {
                properties.add(chk.getText());
            }
        }

        Client client = new Client(txtId.getText(),
                name, address,
                ((RadioButton) grpGender.getSelectedToggle()).getText(),
                txtDob.getValue(),
                properties);
        clientList.add(client);

        for (TextField txt : new TextField[]{txtNic, txtId, txtName, txtAddress}) {
            txt.clear();
        }
        txtDob.setValue(null);
        grpGender.selectToggle(null);
        for (Node child : propertyWrapper.getChildren()) {
            CheckBox chk = (CheckBox) child;
            chk.setSelected(false);
        }

        container.setDisable(true);
    }

    private boolean isValidNic(String nic) {
        if (nic.length() != 10) return false;
        if (!(nic.endsWith("v") || nic.endsWith("V"))) return false;
        String number = nic.substring(0, 9);
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private boolean isValidName(String name){
        for (char c : name.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isSpaceChar(c))) return false;
        }
        return true;
    }

}
