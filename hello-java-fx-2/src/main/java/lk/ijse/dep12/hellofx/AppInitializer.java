package lk.ijse.dep12.hellofx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());   // main
        System.out.println("About to launch the Java FX env.");
        launch(args);
        System.out.println("About to exit from the app");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kuludul FX Program Eka");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.setScene(myKuludulScene());
        stage.show();
        stage.centerOnScreen();
    }

    private Scene myKuludulScene(){
        VBox pane = new VBox();
        for (int i = 0; i < 10; i++) {
            Button btn = new Button("Click Me");
            pane.getChildren().add(btn);
        }
        TextField txt = new TextField();
        Label lbl = new Label("I am a label");
        pane.getChildren().add(lbl);
        pane.getChildren().add(new ColorPicker());
        pane.getChildren().add(new DatePicker());
        pane.getChildren().add(txt);
        return new Scene(pane);
    }
}
