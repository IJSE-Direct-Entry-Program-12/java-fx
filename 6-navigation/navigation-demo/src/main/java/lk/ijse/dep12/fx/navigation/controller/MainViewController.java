package lk.ijse.dep12.fx.navigation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    public AnchorPane root;

    public void btnView1OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane container = FXMLLoader.load(getClass().getResource("/view/View1.fxml"));
        Scene scene = new Scene(container);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
    }

    public void btnView2OnAction(ActionEvent actionEvent) {
    }
}
