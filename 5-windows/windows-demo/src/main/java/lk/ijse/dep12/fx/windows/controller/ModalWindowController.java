package lk.ijse.dep12.fx.windows.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalWindowController {
    public AnchorPane root;

    public void btnWindowOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(new AnchorPane()));
        stage.setTitle("Window Modal");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();
    }

    public void btnApplicationOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(new AnchorPane()));
        stage.setTitle("Application Modal");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.centerOnScreen();
    }
}
