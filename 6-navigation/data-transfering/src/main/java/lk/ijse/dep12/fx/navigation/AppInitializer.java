package lk.ijse.dep12.fx.navigation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml"))));
        primaryStage.setTitle("Data Transferring");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setX(200);

        for (int i = 0; i < 10; i++) {
            Stage stage = new Stage();
            stage.setTitle("Console View");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ConsoleView.fxml"))));
            stage.show();
            stage.setX(primaryStage.getX() + primaryStage.getWidth() + 200);
            stage.setY(Math.random() * 500);
        }
    }
}
