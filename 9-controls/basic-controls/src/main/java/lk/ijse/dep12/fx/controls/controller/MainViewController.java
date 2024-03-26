package lk.ijse.dep12.fx.controls.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.time.LocalDate;

public class MainViewController {

    public ToggleButton btnDisable;
    public ToggleButton btnHide;
    public CheckBox chkBackgroundColor;
    public CheckBox chkTextFill;
    public ColorPicker clrBackground;
    public ColorPicker clrTextFill;
    public Label lbl;
    public Label lblOpacity;
    public RadioButton rdText;
    public RadioButton rdDate;
    public Slider slrOpacity;
    public TextField txt;
    public DatePicker txtDate;
    public Label lblDisplay;
    public ToggleGroup grpInput;

    public void initialize() {
        slrOpacity.valueProperty().addListener((observable, previous, current) -> {
            lblDisplay.setOpacity(current.doubleValue() / 100);
            lblOpacity.setText("Opacity: %.2f".formatted(current.doubleValue()) + "%");
        });
        slrOpacity.setValue(90.);
        txt.textProperty().addListener((observable, previous, current)->{
            lblDisplay.setText(current);
        });
        txt.disabledProperty().addListener((observable, previous, current)->{
            System.out.println(current);
        });
        clrTextFill.setValue(Color.BLACK);
        grpInput.selectToggle(rdText);
        txtDate.setValue(LocalDate.now());
    }

    public void btnDisableOnAction(ActionEvent event) {
        txt.setDisable(!txt.isDisabled());
    }

    public void btnGetTextOnAction(ActionEvent event) {
        System.out.println(txt.getText());
        // txt.setText("");
        txt.clear();
        txt.requestFocus();
    }

    public void btnHideOnAction(ActionEvent event) {
        lbl.setVisible(!lbl.isVisible());
    }

    public void btnSetTextOnAction(ActionEvent event) {
        lbl.setText("Enter something");
        txt.setText("Something");
        txt.requestFocus();
        txt.selectRange(1, 4);
        System.out.println(txt.getSelectedText());
    }

    public void chkBackgroundColorOnAction(ActionEvent event) {
        if (chkBackgroundColor.isSelected()){
            clrBackgroundOnAction(event);
        }else{
            lblDisplay.setBackground(Background.EMPTY);
        }
    }

    public void chkTextFillOnAction(ActionEvent event) {
        if (chkTextFill.isSelected()){
            clrTextFillOnAction(event);
        }else{
            lblDisplay.setTextFill(Color.BLACK);
        }
    }

    public void clrBackgroundOnAction(ActionEvent event) {
        if (chkBackgroundColor.isSelected()){
            lblDisplay.setBackground(Background.fill(clrBackground.getValue()));
        }
    }

    public void clrTextFillOnAction(ActionEvent event) {
        if (chkTextFill.isSelected()){
            lblDisplay.setTextFill(clrTextFill.getValue());
        }
    }

}
