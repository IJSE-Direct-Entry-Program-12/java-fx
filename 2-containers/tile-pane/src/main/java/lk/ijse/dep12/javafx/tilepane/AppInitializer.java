package lk.ijse.dep12.javafx.tilepane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tile Pane Demo");
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.setScene(getMainScene());
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private Scene getMainScene(){
        TilePane container = new TilePane();
        Button btn1 = new Button("Click Me");
        btn1.setPrefSize(150,150);
        Button btn2 = new Button("Click Me");
        Button btn3 = new Button("Click Me");
        TextField txt1 = new TextField();
        txt1.setPrefSize(300, 100);
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        container.getChildren().addAll(btn1, btn2, btn3, txt1, txt2, txt3);
        return new Scene(container);
    }
}
