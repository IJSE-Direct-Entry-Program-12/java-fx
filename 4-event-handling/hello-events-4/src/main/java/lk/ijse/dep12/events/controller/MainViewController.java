package lk.ijse.dep12.events.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainViewController {
    public Button btn1;
    public Button btn2;

    public void initialize(){
//        ButtonEventHandler ref = new ButtonEventHandler();
//        btn1.setOnMouseClicked(ref);

//        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                btn2.setVisible(true);
//            }
//        });

        btn1.setOnAction(event -> btn2.setVisible(!btn2.isVisible()));
    }

    public void btn2OnMouseClicked(MouseEvent mouseEvent) {
        System.out.println("IJSE");
    }
}

//class ButtonEventHandler implements EventHandler{
//
//    @Override
//    public void handle(Event event) {
//        btn2.setVisible(false);
//    }
//}
