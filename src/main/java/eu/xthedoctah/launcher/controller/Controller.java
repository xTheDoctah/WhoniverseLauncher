package eu.xthedoctah.launcher.controller;


import eu.xthedoctah.launcher.auth.Auth;
import eu.xthedoctah.launcher.auth.Error;
import eu.xthedoctah.launcher.auth.Response;
import eu.xthedoctah.launcher.logger.LogType;
import eu.xthedoctah.launcher.logger.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private Logger logger = Logger.getInstance();

    @FXML
    public PasswordField passwordBox;
    @FXML
    public TextField usernameBox;
    @FXML
    public Button closeButton;

    @FXML
    public void pressButton(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (Auth.getInstance().doAuth(usernameBox.getText(), passwordBox.getText())) {
                logger.log(LogType.INFO, "Username: " + Response.getInstance().getSelectedProfile().getName());
            } else {
                logger.log(LogType.ERROR, Error.getInstance().getErrorMessage());
            }
        }
    }


    @FXML
    private void closeWindow(ActionEvent e) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
