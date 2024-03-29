package lk.ijse.dep12.fx.progress.controller;

import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashViewController {
    public Label lblStatus;

    public void initialize(){
        Task initTask = new Task<>(){
            @Override
            protected Object call() throws Exception {
                updateMessage("Please wait");
                // Initialization Logic 1
                Thread.sleep(500);
                updateMessage("Loading plugins");
                // Initialization Logic 2
                Thread.sleep(800);
                updateMessage("Preparing Workspace");
                // Initialization Logic 3
                Thread.sleep(400);
                updateMessage("Finalizing");
                // Initialization Logic 4
                Thread.sleep(300);
                updateMessage("Decorating Stage");
                // Initialization Logic 5
                Thread.sleep(1500);
                return null;
            }
        };
        lblStatus.textProperty().bind(initTask.messageProperty());
        initTask.setOnSucceeded(event ->{
            Stage stage = new Stage();
            stage.setTitle("Progress Bar Demo");
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setResizable(false);
            stage.show();
            stage.centerOnScreen();
            ((Stage)(lblStatus.getScene().getWindow())).close();
        });
        new Thread(initTask).start();
    }
}
