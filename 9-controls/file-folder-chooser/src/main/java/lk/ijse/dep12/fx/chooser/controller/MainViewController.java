package lk.ijse.dep12.fx.chooser.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class MainViewController {

    public Button btnDirectoryChooser;
    public Button btnOpen;
    public Button btnSave;
    public TextField txtDirectory;
    public TextField txtOpen;
    public TextField txtSave;

    public void btnDirectoryChooserOnAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Image Folder");
        File file = directoryChooser.showDialog(btnDirectoryChooser.getScene().getWindow());
        if (file == null){
            txtDirectory.setText("No Folder Selected");
        }else{
            txtDirectory.setText(file.getAbsolutePath());
        }
    }

    public void btnOpenOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image Files");
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("JPEG Image", "*.jpeg", "*.jpg"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("GIF Image", "*.gif"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        // List<File> files = fileChooser.showOpenMultipleDialog(btnOpen.getScene().getWindow());
        File file = fileChooser.showOpenDialog(btnOpen.getScene().getWindow());
        if (file == null){
            txtOpen.setText("No File Selected");
        }else{
            txtOpen.setText(file.getAbsolutePath());
        }
    }

    public void btnSaveOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image File");
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("JPEG Image", "*.jpeg", "*.jpg"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("GIF Image", "*.gif"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        // List<File> files = fileChooser.showOpenMultipleDialog(btnOpen.getScene().getWindow());
        File file = fileChooser.showSaveDialog(btnOpen.getScene().getWindow());
        if (file == null){
            txtSave.setText("No File Selected");
        }else{
            txtSave.setText(file.getAbsolutePath());
        }
    }

}
