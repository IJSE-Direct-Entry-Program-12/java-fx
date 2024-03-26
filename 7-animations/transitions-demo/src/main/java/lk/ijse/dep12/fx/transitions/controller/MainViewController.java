package lk.ijse.dep12.fx.transitions.controller;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Point3D;
import javafx.scene.control.Accordion;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class MainViewController {

    public AnchorPane shpRect;
    public Accordion navigation;

    public void initialize(){
        navigation.setExpandedPane(navigation.getPanes().getFirst());
    }

    public void btnFadeInOnAction(ActionEvent event) {
        FadeTransition ft = new FadeTransition(Duration.seconds(2), shpRect);
        //ft.setDuration(Duration.seconds(2));
        //ft.setNode(shpRect);

        ft.setFromValue(0);
        ft.setToValue(1);

        ft.play();
    }

    public void btnFadeOutOnAction(ActionEvent event) {
        FadeTransition ft = new FadeTransition(Duration.seconds(2), shpRect);
        //ft.setDuration(Duration.seconds(2));
        //ft.setNode(shpRect);

        ft.setFromValue(1);
        ft.setToValue(0);

        ft.play();
    }

    public void btnRotateOnAction(ActionEvent event) {
        RotateTransition rt = new RotateTransition(Duration.millis(500), shpRect);

        rt.setAxis(Rotate.Z_AXIS);
        rt.setFromAngle(45);
        rt.setByAngle(90);

        rt.play();
    }

    public void btnRotateXOnAction(ActionEvent event) {
        RotateTransition rt = new RotateTransition(Duration.millis(500), shpRect);

        // Let's flip
        rt.setAxis(Rotate.X_AXIS);
        rt.setFromAngle(0);
        //rt.setToAngle(90);      // Why can't we see it?
        rt.setToAngle(180);

        rt.play();
    }

    public void btnRotateYOnAction(ActionEvent event) {
        RotateTransition rt = new RotateTransition(Duration.millis(500), shpRect);

        // Let's flip
        rt.setAxis(Rotate.Y_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(180);

        rt.play();
    }

    public void btnScaleDownOnAction(ActionEvent event) {
        ScaleTransition st = new ScaleTransition(Duration.millis(500), shpRect);

        st.setFromX(1);
        st.setToX(0.8);
        st.setFromY(1);
        st.setToY(0.8);

        st.play();
    }

    public void btnScaleUpOnAction(ActionEvent event) {
        ScaleTransition st = new ScaleTransition(Duration.millis(500), shpRect);

        st.setFromX(1);
        st.setToX(1.2);
        st.setFromY(1);
        st.setToY(1.2);

        st.play();
    }

    public void btnSlideFromBottomOnAction(ActionEvent event) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(700));
        tt.setNode(shpRect);

        tt.setFromY(shpRect.getHeight()/2);
        tt.setToY(0);

        tt.play();
    }

    public void btnSlideFromLeftOnAction(ActionEvent event) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(700));
        tt.setNode(shpRect);

        tt.setFromX(-shpRect.getWidth()/2);
        tt.setToX(0);

        tt.play();
    }

    public void btnSlideFromRightOnAction(ActionEvent event) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(700));
        tt.setNode(shpRect);

        tt.setFromX(shpRect.getWidth()/2);
        tt.setToX(0);

        tt.play();
    }

    public void btnSlideFromTopOnAction(ActionEvent event) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(700));
        tt.setNode(shpRect);

        tt.setFromY(-shpRect.getHeight()/2);
        tt.setToY(0);

        tt.play();
    }

}
