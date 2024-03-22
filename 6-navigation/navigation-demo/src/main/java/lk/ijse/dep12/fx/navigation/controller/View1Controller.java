package lk.ijse.dep12.fx.navigation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class View1Controller {
    public AnchorPane root;

    public void btnGoHomeOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane container = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene scene = new Scene(container);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
    }
}
