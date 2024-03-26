package lk.ijse.dep12.fx.navigation.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;

public class MainViewController {
    public AnchorPane container;
    public Button btnDashboard;
    public VBox navigation;

    public void initialize(){
        btnDashboard.fire();
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        navigate(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml")));
    }

    public void btnView1OnAction(ActionEvent actionEvent) throws IOException {
        navigate(FXMLLoader.load(getClass().getResource("/view/View1.fxml")));
    }

    public void btnView2OnAction(ActionEvent actionEvent) throws IOException {
        navigate(FXMLLoader.load(getClass().getResource("/view/View2.fxml")));
    }

    public void btnView3OnAction(ActionEvent actionEvent) throws IOException {
        navigate(FXMLLoader.load(getClass().getResource("/view/View3.fxml")));
    }

    private void navigate(AnchorPane root){
        container.getChildren().clear();
        container.getChildren().add(root);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);

        FadeTransition ft = new FadeTransition(Duration.millis(500), root);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
}
