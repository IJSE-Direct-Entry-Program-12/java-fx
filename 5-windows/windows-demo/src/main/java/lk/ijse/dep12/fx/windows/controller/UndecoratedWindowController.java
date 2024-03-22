package lk.ijse.dep12.fx.windows.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UndecoratedWindowController {
    public AnchorPane root;

    public void btnCloseOnAction(ActionEvent actionEvent) {
        //root.getScene().getWindow().hide();
        ((Stage)root.getScene().getWindow()).close();
    }
}
