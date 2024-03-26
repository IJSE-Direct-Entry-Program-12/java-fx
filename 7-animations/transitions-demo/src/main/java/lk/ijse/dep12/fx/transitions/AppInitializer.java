package lk.ijse.dep12.fx.transitions;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java FX: Transitions");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
