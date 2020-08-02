package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utility.UserData;

import java.security.Key;

public class LoginController {
    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField pfPassword;
    // metoda dostarczająca logikę do logowania użytkownika
    private void login(){
        boolean isLogged = UserData.users.stream()
                .anyMatch(user ->
                        user.getEmail().equals(tfLogin.getText()) &&
                                user.getPassword().equals(pfPassword.getText()));
        if(isLogged){
            System.out.println("zalogowano");
            tfLogin.setStyle(null);
            pfPassword.setStyle(null);
        } else {
            System.out.println("niezalogowano");
            tfLogin.clear();
            pfPassword.clear();
            tfLogin.setStyle("-fx-border-color: red; -fx-border-width: 3px");
            pfPassword.setStyle("-fx-border-color: red; -fx-border-width: 3px");
        }
    }
    @FXML   // kliknięcie na button (button)
    void loginAction(ActionEvent event) {
        login();
    }
    @FXML   // wciśnięce Enter w dowolnym miejscu na oknie aplikacji (vbox)
    void keyLoginAction(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            login();
        } else if(event.getCode() == KeyCode.ESCAPE){
            Platform.exit();    // zamknięcie okna aplikacji wywołanie metody close()
        }
    }
}