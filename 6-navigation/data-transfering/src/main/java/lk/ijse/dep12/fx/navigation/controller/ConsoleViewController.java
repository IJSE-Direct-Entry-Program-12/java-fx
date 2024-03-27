package lk.ijse.dep12.fx.navigation.controller;

import javafx.scene.control.TextArea;

public class ConsoleViewController {
    public TextArea txtDisplay;

    public void initialize(){
        // Subscribe
        MainViewController.stringProperty.addListener((observable, previous, current)->{
            txtDisplay.appendText(current + "\n");
        });
    }
}
