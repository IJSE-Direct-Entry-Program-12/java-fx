package lk.ijse.dep12.fx.navigation.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class MainViewController {
    public TextField txtMessage;

    public static SimpleStringProperty stringProperty = new SimpleStringProperty();

    public void btnSendOnAction(ActionEvent actionEvent) {
        stringProperty.setValue(txtMessage.getText());
        txtMessage.clear();
        txtMessage.requestFocus();
    }
}
