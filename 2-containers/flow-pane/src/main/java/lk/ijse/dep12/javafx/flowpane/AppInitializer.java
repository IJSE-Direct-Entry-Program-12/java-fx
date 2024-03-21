package lk.ijse.dep12.javafx.flowpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Flow Pane Demo");
        primaryStage.setScene(getMainScene());
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private Scene getMainScene(){
        FlowPane container = new FlowPane();
        Button btn1 = new Button("Click Me");
        btn1.setPrefWidth(200);
        btn1.setPrefHeight(200);
        Button btn2 = new Button("Click Me");
        Button btn3 = new Button("Click Me");
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        txt2.setPrefSize(200, 100);
        TextField txt3 = new TextField();
        container.getChildren().addAll(btn1, btn2, btn3, txt1, txt2, txt3);
        return new Scene(container);
    }
}
