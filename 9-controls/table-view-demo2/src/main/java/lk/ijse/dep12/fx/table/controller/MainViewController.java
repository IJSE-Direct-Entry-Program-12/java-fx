package lk.ijse.dep12.fx.table.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import lk.ijse.dep12.fx.table.Employee;

import java.util.ArrayList;

public class MainViewController {

    public Button btnAdd;
    public Button btnDelete;
    public Button btnNewEmployee;
    public Button btnRemove;
    public Button btnSave;
    public GridPane contactWrapper;
    public GridPane container;
    public HBox genderWrapper;
    public ToggleGroup grpGender;
    public ListView<String> lstContact;
    public RadioButton rdFemale;
    public RadioButton rdMale;
    public AnchorPane root;
    public TableView<Employee> tblEmployee;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtFullName;
    public TextField txtId;
    public TextField txtNic;

    public void initialize() {
        tblEmployee.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmployee.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblEmployee.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fullName"));
        tblEmployee.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
            tblEmployee.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("contactStatus"));

        for (Node node : container.lookupAll(".label")) {
            Label lbl = (Label) node;
            lbl.setLabelFor(container.lookup(lbl.getAccessibleText()));
        }
        container.setDisable(true);
        btnRemove.setVisible(false);
        btnRemove.setDisable(true);

        lstContact.getSelectionModel().selectedItemProperty().addListener((observable, previous, current) -> {
            btnRemove.setDisable(current == null);
        });
    }

    private String generateNewEmployeeId() {
        ObservableList<Employee> employeeList = tblEmployee.getItems();
        if (employeeList.isEmpty()) return "IJSE-0001";
        int newId = Integer.parseInt(employeeList.getLast().getId().replace("IJSE-", "")) + 1;
        return "IJSE-%04d".formatted(newId);
    }

    public void btnNewEmployeeOnAction(ActionEvent event) {
        container.setDisable(false);
        txtId.setText(generateNewEmployeeId());
        txtNic.requestFocus();
    }

    public void btnAddOnAction(ActionEvent event) {
        String contact = txtContact.getText();
        txtContact.getStyleClass().remove("error");
        if (contact.isBlank()) {
            txtContact.requestFocus();
            txtContact.selectAll();
            return;
        }
        if (!isValidContact(contact.strip())) {
            txtContact.requestFocus();
            txtContact.selectAll();
            txtContact.getStyleClass().add("error");
            return;
        }
        ObservableList<String> contactList = lstContact.getItems();
        if (contactList.contains(contact.strip())){
            new Alert(Alert.AlertType.ERROR, "Contact number already added").show();
            txtContact.requestFocus();
            txtContact.getStyleClass().add("error");
            return;
        }
        if (existsContact(contact.strip())){
            new Alert(Alert.AlertType.ERROR, "Contact already associated with another employee").show();
            txtContact.requestFocus();
            txtContact.getStyleClass().add("error");
            return;
        }
        contactList.add(contact.strip());
        txtContact.clear();
        txtContact.requestFocus();
        btnRemove.setVisible(true);
    }

    private boolean existsContact(String contact){
        ObservableList<Employee> employeeList = tblEmployee.getItems();
        for (Employee employee : employeeList) {
            if (employee.getContactList().contains(contact)) return true;
        }
        return false;
    }

    private boolean isValidContact(String contact) {
        if (contact.length() != 11) return false;
        String[] splitText = contact.split("-");// 011-1234567
        if (splitText.length != 2) return false;
        if (!(splitText[0].length() == 3 && splitText[1].length() == 7)) return false;
        return isNumber(splitText[0]) && isNumber(splitText[1]);
    }

    private boolean isNumber(String input){
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public void txtContactOnAction(ActionEvent event) {
        btnAdd.fire();
    }

    public void lstContactOnKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    public void btnRemoveOnAction(ActionEvent event) {
        ObservableList<String> contactList = lstContact.getItems();
        contactList.remove(lstContact.getSelectionModel().getSelectedItem());
    }

    public void btnSaveOnAction(ActionEvent event) {

        boolean valid = true;
        for (Node node : container.lookupAll(".error")) {
            node.getStyleClass().remove("error");
        }

        /* Data Validation */
        if (grpGender.getSelectedToggle() == null){
            valid = false;
            rdMale.requestFocus();
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
        String name = txtFullName.getText().strip();
        if (name.isBlank() || name.length() < 3 || !isValidName(name)){
            valid = false;
            txtFullName.requestFocus();
            txtFullName.getStyleClass().add("error");
        }

        String nic = txtNic.getText().strip();
        if (!isValidNic(nic)){
            valid = false;
            txtNic.requestFocus();
            txtNic.getStyleClass().add("error");
        }
        if (existsNic(nic)){
            valid = false;
            new Alert(Alert.AlertType.ERROR, "NIC already associated with another employee").show();
            txtNic.requestFocus();
            txtNic.getStyleClass().add("error");
        }

        if (!valid) return;

        ArrayList<String> contactList = new ArrayList<>();
        contactList.addAll(lstContact.getItems());

        if (btnSave.getText().contains("SAVE")){
            Employee newEmployee = new Employee(txtId.getText(), nic, name, address.strip(),
                    ((RadioButton) grpGender.getSelectedToggle()).getText(), contactList);
            ObservableList<Employee> employeeList = tblEmployee.getItems();
            employeeList.add(newEmployee);
        }else{
            /* Todo: Implement the update part */
        }
        for (Node node : container.lookupAll(".text-field")) {
            TextField txt = (TextField) node;
            txt.clear();
        }
        grpGender.selectToggle(null);
        lstContact.getItems().clear();
        container.setDisable(true);
    }

    private boolean existsNic(String nic){
        ObservableList<Employee> employeeList = tblEmployee.getItems();
        for (Employee employee : employeeList) {
            if (employee.getNic().equals(nic)) return true;
        }
        return false;
    }

    private boolean isValidNic(String nic){
        if (nic.length() != 10) return false;
        if (!(nic.endsWith("v") || nic.endsWith("V"))) return false;
        return isNumber(nic.substring(0, 9));
    }

    private boolean isValidName(String name){
        for (char c : name.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isSpaceChar(c))) return false;
        }
        return true;
    }

    public void btnDeleteOnAction(ActionEvent event) {

    }

    public void tblEmployeeOnKeyPressed(KeyEvent event) {

    }



}
