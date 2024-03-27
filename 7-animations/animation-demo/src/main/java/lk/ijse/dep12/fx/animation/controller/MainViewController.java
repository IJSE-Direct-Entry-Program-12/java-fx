package lk.ijse.dep12.fx.animation.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainViewController {
    public Label lblTitle;
    private final Timeline TIME_LINE = new Timeline();
    public Label lblTime;

    public void initialize(){
        lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        Timeline tlTime = new Timeline();
        KeyFrame frame = new KeyFrame(Duration.seconds(1),
                ae -> lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        tlTime.getKeyFrames().add(frame);
        tlTime.setCycleCount(Animation.INDEFINITE);
        tlTime.play();

        KeyFrame kf1 = new KeyFrame(Duration.millis(500), ae -> lblTitle.setTextFill(Color.RED));
        KeyFrame kf2 = new KeyFrame(Duration.millis(200), ae -> {
            lblTitle.setTextFill(Color.GREEN);
            lblTitle.setScaleX(1.5);
            lblTitle.setScaleY(1.5);
        });
        KeyFrame kf3 = new KeyFrame(Duration.millis(700), ae -> lblTitle.setTextFill(Color.BLUE));
        KeyFrame kf4 = new KeyFrame(Duration.millis(100), ae -> {
            lblTitle.setTextFill(Color.YELLOW);
            lblTitle.setRotate(5);
        });
        KeyFrame kf5 = new KeyFrame(Duration.millis(800), ae -> {
            lblTitle.setTextFill(Color.BLACK);
            lblTitle.setRotate(0);
            lblTitle.setScaleX(1);
            lblTitle.setScaleY(1);
        });
        TIME_LINE.getKeyFrames().addAll(kf1, kf2, kf3, kf4, kf5);
        TIME_LINE.setCycleCount(Animation.INDEFINITE);
        TIME_LINE.setAutoReverse(true);
    }

    public void btnPlayOnAction(ActionEvent actionEvent) {
        TIME_LINE.play();
    }

    public void btnStopOnAction(ActionEvent actionEvent) {
        TIME_LINE.stop();
    }
}
