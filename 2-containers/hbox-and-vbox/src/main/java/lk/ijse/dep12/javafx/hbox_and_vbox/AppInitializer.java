package lk.ijse.dep12.javafx.hbox_and_vbox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HBox and VBox Demo");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setScene(getMainScene());
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private Scene getMainScene(){
        VBox container = new VBox();
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        Label lblUsername = new Label("Username");
        Label lblPassword = new Label("Password");
        lblUsername.setPrefWidth(100);
        lblPassword.setPrefWidth(100);
        TextField txtUsername = new TextField();
        PasswordField txtPassword = new PasswordField();
        row1.getChildren().addAll(lblUsername, txtUsername);
        row2.getChildren().addAll(lblPassword, txtPassword);
        container.setSpacing(10);
        container.getChildren().addAll(row1, row2);
        return new Scene(container);
    }
}
