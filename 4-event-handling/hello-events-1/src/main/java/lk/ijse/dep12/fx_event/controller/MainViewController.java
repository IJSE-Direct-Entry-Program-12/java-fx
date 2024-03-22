package lk.ijse.dep12.fx_event.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainViewController {
    public Button btnClickMe1;
    public Button btnDoSomething;

    public MainViewController() {
        System.out.println("Constructor: " + btnClickMe1);
    }

    public void initialize(){
        btnClickMe1.setText("Hello");
        btnClickMe1.setOnMouseEntered(event -> {
            //System.out.println("Maarai, habai dan athi");
            //btnClickMe1.setDisable(true);
            btnClickMe1.setVisible(false);
        });
        btnDoSomething.setOnMouseClicked(event ->{
            btnClickMe1.setVisible(true);
        });
    }
}


