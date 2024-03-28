package lk.ijse.dep12.fx.navigation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep12.fx.navigation.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class LoginViewController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnLogin;

    private ArrayList<User> userList = new ArrayList<>();

    public void initialize(){
        userList.add(new User("Kasun Sampath", "kasun@ijse.lk", "kasun123"));
        userList.add(new User("Nuwan Ramindu", "nuwan@ijse.lk", "nuwan123"));
        userList.add(new User("Ruwan Perera", "ruwan@ijse.lk", "ruwan123"));
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtUsername.getText().isBlank()){
            txtUsername.requestFocus();
            return;
        }else if (txtPassword.getText().isBlank()){
            txtPassword.requestFocus();
            return;
        }

        for (User user : userList) {
           if (user.getUsername().equals(txtUsername.getText().strip())
                    && user.getPassword().equals(txtPassword.getText().strip())){
               Stage stage = new Stage();

               URL resource = getClass().getResource("/view/MainView.fxml");
               //AnchorPane container = FXMLLoader.load(resource);
               FXMLLoader fxmlLoader = new FXMLLoader(resource);
               AnchorPane container = fxmlLoader.load();
               Scene mainScene = new Scene(container);
               stage.setScene(mainScene);

               MainViewController controller = fxmlLoader.getController();
               controller.initData(user);

               //stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml"))));
               stage.setTitle("Main View");
               stage.show();
               stage.centerOnScreen();
               stage.setOnCloseRequest(windowEvent -> {
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to log out?",
                           ButtonType.YES, ButtonType.NO);
                   alert.setTitle("Logout?");
                   alert.setHeaderText("Logout");
                   Optional<ButtonType> buttonType = alert.showAndWait();
                   if (buttonType.get() == ButtonType.NO){
                       windowEvent.consume();
                   }else{
                       Stage loginStage = new Stage();
                       try {
                           loginStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"))));
                       } catch (IOException e) {
                           throw new RuntimeException(e);
                       }
                       loginStage.setResizable(false);
                       loginStage.setTitle("Login");
                       loginStage.show();
                       loginStage.centerOnScreen();
                   }
               });
               ((Stage)(btnLogin.getScene().getWindow())).close();
               return;
           }
        }

        new Alert(Alert.AlertType.ERROR, "Invalid login credentials").show();
        txtUsername.requestFocus();
    }
}
