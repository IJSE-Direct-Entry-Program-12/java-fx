package lk.ijse.dep12.fx.navigation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        AnchorPane container = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"))
//        Scene scene = new Scene(container);
//        primaryStage.setScene(scene);

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml"))));
        primaryStage.setTitle("Java FX Navigation Demo");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
