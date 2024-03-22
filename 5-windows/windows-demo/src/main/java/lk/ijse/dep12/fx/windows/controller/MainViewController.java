package lk.ijse.dep12.fx.windows.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainViewController {
    public void btnNormalOnAction(ActionEvent event) {
        Stage stage = new Stage();
        AnchorPane container = new AnchorPane();
        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.setTitle("New Window");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
        stage.centerOnScreen();
    }

    public void btnUtilityOnAction(ActionEvent event) {
        Stage stage = new Stage();
        AnchorPane container = new AnchorPane();
        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.setTitle("New Utility Window");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        stage.centerOnScreen();
    }

    public void btnModalOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane container = FXMLLoader.load(getClass().getResource("/view/ModalWindow.fxml"));
        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.setTitle("Modal Windows");
        stage.show();
        stage.centerOnScreen();
    }

    public void btnUndecoratedOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane container = FXMLLoader.load(getClass().getResource("/view/UndecoratedWindow.fxml"));
        container.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX());
            stage.setY(mouseEvent.getScreenY());
        });
        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.setTitle("Undecorated Window");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.centerOnScreen();
    }

    public void btnGlassOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane container = FXMLLoader.load(getClass().getResource("/view/GlassWindow.fxml"));
        Scene scene = new Scene(container);
        stage.setScene(scene);
        container.setOpacity(0.5);
        container.setBackground(Background.EMPTY);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Glass Window");
        stage.show();
        stage.centerOnScreen();
    }
}
