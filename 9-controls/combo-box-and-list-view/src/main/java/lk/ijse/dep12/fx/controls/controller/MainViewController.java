package lk.ijse.dep12.fx.controls.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    public Button btnAdd;
    public Button btnBack;
    public Button btnClear;
    public Button btnNext;
    public ComboBox<String> cmbInputs;
    public Label lblOutput;
    public ListView<String> lstView1;
    public ListView<String> lstView2;
    public TextField txtInput;

    public void initialize(){
        cmbInputs.getSelectionModel().selectedItemProperty()
                .addListener((observable, previous, current) ->{
            lblOutput.setText(current);
        });
        lstView1.getSelectionModel().selectedItemProperty()
                .addListener((observable, previous, current)->{
                    btnNext.setDisable(current == null);
                });
        lstView2.getSelectionModel().selectedItemProperty()
                .addListener((observable, previous, current)->{
                    btnBack.setDisable(current == null);
                });

        ObservableList<String> optionList = lstView1.getItems();
        optionList.add("Option 1");
        optionList.add("Option 2");
        optionList.add("Option 3");
        optionList.add("Option 4");

        btnNext.setDisable(true);
        btnBack.setDisable(true);
    }

    public void btnAddOnAction(ActionEvent event) {
        if (txtInput.getText().isBlank()){
            txtInput.requestFocus();
            return;
        }

        ObservableList<String> inputList = cmbInputs.getItems();
        inputList.add(txtInput.getText().strip());

        txtInput.clear();
        txtInput.requestFocus();
    }

    public void btnClearOnAction(ActionEvent event) {
         cmbInputs.getItems().clear();
         lblOutput.setText("");
         lstView1.getSelectionModel().clearSelection();
         lstView2.getSelectionModel().clearSelection();
    }

    public void btnNextOnAction(ActionEvent event) {
        ObservableList<String> list1 = lstView1.getItems();
        ObservableList<String> list2 = lstView2.getItems();

        list2.add(list1.remove(lstView1.getSelectionModel().getSelectedIndex()));
    }

    public void btnBackOnAction(ActionEvent event) {
        ObservableList<String> list1 = lstView1.getItems();
        ObservableList<String> list2 = lstView2.getItems();

        list1.add(list2.remove(lstView2.getSelectionModel().getSelectedIndex()));
    }


    public void btnDemo2OnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("CombBox and ListView Demo2");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Demo2View.fxml"))));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }
}
