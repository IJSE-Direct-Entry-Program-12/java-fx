package lk.ijse.dep12.javafx.anchorpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Anchor Pane Demo");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setScene(getMainScene());
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private Scene getMainScene(){
        AnchorPane container = new AnchorPane();
        Button btn = new Button("Click Me");
        Button newButton = new Button("New Button");
        newButton.setLayoutX(100);
        newButton.setLayoutY(50);
        container.getChildren().add(btn);
        container.getChildren().add(newButton);
        AnchorPane.setTopAnchor(btn, 50.0);
        AnchorPane.setRightAnchor(btn, 100.0);
        AnchorPane.setBottomAnchor(btn, 50.0);
//        AnchorPane.setLeftAnchor(btn, 0.0);
        return new Scene(container);
    }
}
