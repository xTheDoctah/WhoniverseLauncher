package eu.xthedoctah.launcher.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private static String password;
    private static String username;
    @FXML
    public PasswordField passwordBox;
    @FXML
    public TextField usernameBox;

    @FXML
    public void pressButton(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            password = passwordBox.getText();
            username = usernameBox.getText();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
