package lk.ijse.dep12.fx.validation.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Set;

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
        txtName.requestFocus();
    }

    private String generateNewClientId() {
        return "C-0001";
    }

    public void btnSaveOnAction(ActionEvent event) {

    }

}
