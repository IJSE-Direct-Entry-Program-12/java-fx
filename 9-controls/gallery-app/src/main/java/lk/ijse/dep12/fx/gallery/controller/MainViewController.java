package lk.ijse.dep12.fx.gallery.controller;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

import java.io.File;

public class MainViewController {
    public ScrollPane imageContainerWrapper;
    public StackPane notFoundContainer;
    public TextField txtLocation;
    public TilePane imageContainer;
    public AnchorPane root;
    public Button btnBrowse;

    public void initialize(){
        txtLocation.setText(System.getProperty("user.home"));
        btnBrowse.fire();
    }

    public void btnBrowseOnAction(ActionEvent actionEvent) {
        notFoundContainer.setVisible(true);
        imageContainerWrapper.setVisible(false);

        if (txtLocation.getText().isBlank()) {
            txtLocation.requestFocus();
            return;
        }

        File path = new File(txtLocation.getText());
        if (!path.exists()) {
            new Alert(Alert.AlertType.ERROR, "Invalid folder location").show();
            return;
        }else if (!path.isDirectory()){
            new Alert(Alert.AlertType.ERROR, "Location does not point to a folder").show();
            return;
        }

        imageContainer.getChildren().clear();
        for (File file : path.listFiles()) {
            if (!file.isFile()) continue;
            if (file.getName().endsWith("jpeg") || file.getName().endsWith("jpg") ||
                    file.getName().endsWith("bmp") || file.getName().endsWith("png") ||
                    file.getName().endsWith("gif")){
                ImageView imageView = new ImageView(file.toURI().toString());
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);
                imageContainer.getChildren().add(imageView);
                if (!imageContainerWrapper.isVisible()){
                    imageContainerWrapper.setVisible(true);
                    notFoundContainer.setVisible(false);
                }
            }
        }
    }
}
