package lk.ijse.dep12.fx.alerts.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class MainViewController {
    public void btnInfoOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Database has been migrated successfully");
        alert.setTitle("Information Alert");
        alert.setHeaderText("Important");
        ImageView iconView = new ImageView("/icon/information.png");
        iconView.setFitWidth(64);
        iconView.setFitHeight(64);
        alert.setGraphic(iconView);
        alert.show();
        System.out.println("Information Alert");
    }

    public void btnConfirmOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to exit?",
                ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Exit?");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES){
            Platform.exit();
        }else{
            System.out.println("User does not want to exit");
        }
    }

    public void btnWarnOnAction(ActionEvent actionEvent) {
        ButtonType btnActivate = new ButtonType("Activate");
        ButtonType btnStartTrial = new ButtonType("Start Trial");
        Alert alert = new Alert(Alert.AlertType.WARNING, "Your subscription has been expired",
                btnActivate, btnStartTrial, ButtonType.CANCEL);
        alert.setTitle("Subscription Expired");
        alert.setHeaderText("Subscription Expired");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == btnActivate){
            System.out.println("Activated");
        }else if (buttonType.get() == btnStartTrial){
            System.out.println("Trial activated");
        }else{
            System.out.println("Canceled");
        }
    }

    public void btnErrorOnAction(ActionEvent actionEvent) {
        ButtonType btnTryAgain = new ButtonType("Try again", ButtonBar.ButtonData.OK_DONE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong, please try again",
                btnTryAgain);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.show();
    }

    public void btnPromptOnAction(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Filename");
        dialog.setTitle("New FXML File");
        Optional<String> inputText = dialog.showAndWait();
        if (inputText.isPresent()){
            System.out.println(inputText.get());
        }else{
            System.out.println("Invalid Input");
        }
    }
}
