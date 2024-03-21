package lk.ijse.dep12.fx_events.controller;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainViewController {
    public Label lbl;
    public AnchorPane root;

    public void initialize(){
        lbl.setVisible(false);
        Platform.runLater(()->{
            root.getScene().setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.RIGHT){
                    lbl.setLayoutX(lbl.getLayoutX() + 10);
                }else if (keyEvent.getCode() == KeyCode.LEFT){
                    lbl.setLayoutX(lbl.getLayoutX() - 10);
                }else if (keyEvent.getCode() == KeyCode.UP){
                    lbl.setLayoutY(lbl.getLayoutY() - 10);
                }else if (keyEvent.getCode() == KeyCode.DOWN){
                    lbl.setLayoutY(lbl.getLayoutY() + 10);
                }
            });
        });
    }

    public void rootOnMouseMoved(MouseEvent mouseEvent) {
        lbl.setLayoutX(mouseEvent.getX() - (lbl.getWidth() / 2));
        lbl.setLayoutY(mouseEvent.getY() - (lbl.getHeight() / 2));
        //System.out.printf("(x=%.1f, y=%.1f) \n", mouseEvent.getX(), mouseEvent.getY());
    }

    public void rootOnMouseEntered(MouseEvent mouseEvent) {
        lbl.setVisible(true);
    }

    public void rootOnMouseExited(MouseEvent mouseEvent) {
        lbl.setVisible(false);
    }
}
