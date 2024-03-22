package lk.ijse.dep12.fx.windows.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GlassWindowController {
    public AnchorPane root;

    public void btnExitOnAction(ActionEvent actionEvent) {
        ((Stage)root.getScene().getWindow()).close();
    }
}
