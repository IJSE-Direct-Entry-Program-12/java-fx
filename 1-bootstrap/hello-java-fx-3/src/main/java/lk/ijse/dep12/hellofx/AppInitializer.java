package lk.ijse.dep12.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello Java FX");
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setScene(getMainScene());
        stage.show();
        stage.centerOnScreen();
    }

    private Scene getMainScene(){
        TilePane container = new TilePane();
        for (int i = 0; i < 20; i++) {
            TextField txt = new TextField();
            container.getChildren().add(txt);
        }
        return new Scene(container);
    }
}
