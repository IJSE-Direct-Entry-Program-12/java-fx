package lk.ijse.dep12.fx.validation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lk.ijse.dep12.fx.validation.Program;

import java.util.ArrayList;

public class MainViewController {

    public Button btnNewProgram;
    public Button btnSave;
    public CheckBox chkGraduates;
    public CheckBox chkProfessionals;
    public CheckBox chkSchoolLeavers;
    public CheckBox chkUndergraduates;
    public ToggleGroup grpType;
    public RadioButton rdFullTime;
    public RadioButton rdPartTime;
    public AnchorPane root;
    public TextField txtCode;
    public TextField txtId;
    public TextField txtName;
    public VBox vBox;
    public Label lblAudience;
    public VBox audienceWrapper;

    private ArrayList<Program> programList = new ArrayList<>();

    public void initialize(){
        for (Node child : vBox.getChildren()) {
            HBox hBox = (HBox) child;
            for (int i = 0; i < hBox.getChildren().size(); i++) {
                if (hBox.getChildren().get(i) instanceof Label lbl){
                    lbl.setLabelFor(hBox.getChildren().get(i + 1));
                }
            }
        }
        lblAudience.setLabelFor(chkSchoolLeavers);

        enableUI(false);
    }

    private void enableUI(boolean enable){
        vBox.setDisable(!enable);
        btnSave.setDisable(!enable);
    }

    private String generateNewProgramId(){
        if (programList.isEmpty()) return "P-001";

        int newId = Integer.parseInt(programList.get(programList.size() - 1).getId().replace("P-", "")) + 1;
        return "P-%03d".formatted(newId);
    }

    public void btnNewProgramOnAction(ActionEvent event) {
        enableUI(true);
        txtId.setText(generateNewProgramId());
        txtName.requestFocus();
    }

    public void btnSaveOnAction(ActionEvent event) {
        String name = txtName.getText().strip();
        String code = txtCode.getText();
        boolean valid = true;

        for (Node node : new Node[]{txtName, txtCode, rdFullTime, rdPartTime, audienceWrapper}) {
            node.getStyleClass().remove("error");
        }

        boolean audience = false;
        for (Node child : audienceWrapper.getChildren()) {
            CheckBox chk = (CheckBox) child;
            if (chk.isSelected()) {
                audience = true;
                break;
            }
        }
        if (!audience){
            audienceWrapper.getStyleClass().add("error");
            chkSchoolLeavers.requestFocus();
            valid = false;
        }

        if (grpType.getSelectedToggle() == null){
            rdFullTime.getStyleClass().add("error");
            rdPartTime.getStyleClass().add("error");
            rdFullTime.requestFocus();
            valid = false;
        }

        if (!code.isEmpty()){
            if (code.isBlank() || !(code.strip().length() >= 3 && code.strip().length() <= 5)){
                txtCode.getStyleClass().add("error");
                txtCode.requestFocus();
                valid = false;
            }
        }

        if (name.isBlank()){
            valid = false;
            txtName.requestFocus();
            txtName.getStyleClass().add("error");
        }

        if (!valid) return;

        ArrayList<String> audienceList = new ArrayList<>();
        for (Node child : audienceWrapper.getChildren()) {
            CheckBox chk = (CheckBox) child;
            if (chk.isSelected()) {
                audienceList.add(chk.getText());
            }
        }

        Program program = new Program(txtId.getText(),
                name, code,
                ((RadioButton) grpType.getSelectedToggle()).getText(),
                audienceList);
        programList.add(program);

        txtId.clear();
        txtName.clear();
        txtCode.clear();
        grpType.selectToggle(null);
        for (Node child : audienceWrapper.getChildren()) {
            CheckBox chk = (CheckBox) child;
            chk.setSelected(false);
        }

        enableUI(false);
    }

}
