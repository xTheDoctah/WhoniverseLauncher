package eu.xthedoctah.launcher.controller;


import eu.xthedoctah.launcher.auth.Auth;
import eu.xthedoctah.launcher.auth.Error;
import eu.xthedoctah.launcher.auth.Response;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public PasswordField passwordBox;
    @FXML
    public TextField usernameBox;

    @FXML
    public void pressButton(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            Auth.getInstance().doAuth(usernameBox.getText(), passwordBox.getText());
        }
        //TODO:If the response is null then check the Error class.
        System.out.println(Error.getInstance());
        System.out.println(Response.getInstance());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
