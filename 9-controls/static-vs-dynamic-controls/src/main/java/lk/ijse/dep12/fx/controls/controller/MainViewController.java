package lk.ijse.dep12.fx.controls.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainViewController {
    public VBox contactsWrapper;

    public void btnAddOnAction(ActionEvent actionEvent) {
        TextField txt = new TextField();
        Button btnRemove = new Button("Remove");
        HBox hBox = new HBox(txt, btnRemove);
        contactsWrapper.getChildren().add(hBox);
        btnRemove.setOnAction(ae -> contactsWrapper.getChildren().remove(hBox));
    }
}
