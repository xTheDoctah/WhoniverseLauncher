package eu.xthedoctah.launcher.controller;


import eu.xthedoctah.launcher.auth.Auth;
import eu.xthedoctah.launcher.auth.Error;
import eu.xthedoctah.launcher.auth.Response;
import eu.xthedoctah.launcher.logger.LogType;
import eu.xthedoctah.launcher.logger.Logger;
import eu.xthedoctah.launcher.model.Profile;
import eu.xthedoctah.launcher.settings.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public PasswordField passwordBox;
    @FXML
    public TextField usernameBox;
    @FXML
    public Button closeButton;
    @FXML
    public CheckBox rememberMe;
    private Logger logger = Logger.getInstance();
    private Boolean isChecked = false;

    @FXML
    public void pressButton(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (Auth.getInstance().doAuth(usernameBox.getText(), passwordBox.getText())) {
                logger.log(LogType.INFO, "Username: " + Response.getInstance().getSelectedProfile().getName());
                if (this.isChecked)
                    Settings.getInstance().createUser(new Profile(usernameBox.getText(), passwordBox.getText(), true));
            } else {
                logger.log(LogType.ERROR, Error.getInstance().getErrorMessage());
            }
        }
    }


    @FXML
    public void closeWindow(ActionEvent e) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void rememberMe(ActionEvent e) {
        if (e.getSource().equals(rememberMe)) {
            this.isChecked = rememberMe.isSelected();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
