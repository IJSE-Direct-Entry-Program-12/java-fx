package lk.ijse.dep12.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello Java FX 4");
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.setScene(getMainScene());
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private Scene getMainScene(){
        VBox container = new VBox();
        container.getChildren().addAll(
                new Button("Click Me"),
                new TextField(),
                new ColorPicker(),
                new DatePicker(),
                new ListView<>(),
                new ComboBox<>(),
                new TableView<>(),
                new ProgressBar()
        );
        return new Scene(container);
    }
}
