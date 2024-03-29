package lk.ijse.dep12.fx.progress.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainViewController {
    public ProgressBar pbInstall;
    public Label lblStatus;
    public Label lblProgress;
    public ProgressBar pbRestore;
    public Label lblRestoreStatus;
    public Label lblRestoreProgress;
    public Button btnInstall;
    public Button btnRestore;

    public void btnInstallOnAction(ActionEvent actionEvent) {
       Task timeConsumingTask = new Task<>(){
           @Override
           protected Object call() throws Exception {
               updateMessage("Loading Plugins");
               // Code goes here for loading plugins
               Thread.sleep(200);
               updateProgress(25, 100);
               updateMessage("Initializing Database Connection");
               // Code goes here for initialize database connection
               Thread.sleep(500);
               updateProgress(50, 100);
               updateMessage("Loading Extensions");
               // Code goes here for loading extensions
               Thread.sleep(200);
               updateProgress(75,100);
               updateMessage("Finalizing installation process");
               // Code goes here for finalizing installation process
               Thread.sleep(500);
               updateProgress(100,100);
               updateMessage("Finished. Click to restart again!");
               return null;
           }
       };

       timeConsumingTask.progressProperty().addListener((observable, previous, current) -> {
           double progress = current.doubleValue() * 100;
           lblProgress.setText("%.2f".formatted(progress) + "%");
       });
       lblStatus.textProperty().bind(timeConsumingTask.messageProperty());
       pbInstall.progressProperty().bind(timeConsumingTask.progressProperty());

       new Thread(timeConsumingTask).start();
    }

    public void btnRestoreOnAction(ActionEvent actionEvent) {
        Task timeConsumingTask = new Task<>(){
            @Override
            protected Object call() throws Exception {
                updateMessage("Installing");
                for (int i = 0; i <= 100; i++) {
                    if (i == 20){
                        updateMessage("Loading plugins");
                        // Code goes here for loading plugins
                        Thread.sleep(2000);
                    }else if (i == 50){
                        updateMessage("Initializing Plugins");
                        // Code goes here for initializing plugins
                        Thread.sleep(3000);
                    }else if (i == 90){
                        updateMessage("Finalizing the installation process");
                        // Code goes here for finalizing the installation process
                        Thread.sleep(5000);
                    }
                    updateProgress(i, 100);
                    Thread.sleep(100);
                }
                updateMessage("Installation completed. Click to restart again!");
                return null;
            }
        };

        timeConsumingTask.progressProperty().addListener((observable, previous, current) -> {
            double progress = current.doubleValue() * 100;
            lblRestoreProgress.setText("%.2f".formatted(progress) + "%");
        });
        lblRestoreStatus.textProperty().bind(timeConsumingTask.messageProperty());
        pbRestore.progressProperty().bind(timeConsumingTask.progressProperty());

        new Thread(timeConsumingTask).start();
    }
}
