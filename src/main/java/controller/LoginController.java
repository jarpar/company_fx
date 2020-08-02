package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController {
    private void login() {
        System.out.println("test");
    }

    @FXML
    private TextField tfLogin;


    @FXML
    private PasswordField pfPassword;

    @FXML
    void loginAction(ActionEvent event) {

    }

    @FXML
    void keyLoginAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            login();
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            Platform.exit();
        }
    }
}
