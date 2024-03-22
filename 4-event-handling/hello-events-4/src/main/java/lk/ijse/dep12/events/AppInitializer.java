package lk.ijse.dep12.events;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("/view/MainView.fxml");
        //System.out.println("Just about to load");
        AnchorPane container = FXMLLoader.load(resource);
        //System.out.println("Loaded");
        Scene mainScene = new Scene(container);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Event Handling in Java FX - 4");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
