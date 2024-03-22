package lk.ijse.dep12.fx_events.controller;

import javafx.scene.input.MouseEvent;

public class MainViewController {
    public void btnClickOnMouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getClickCount());
        System.out.println("IJSE");
    }
}
