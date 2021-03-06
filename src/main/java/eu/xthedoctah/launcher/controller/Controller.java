package eu.xthedoctah.launcher.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import eu.xthedoctah.launcher.auth.Auth;
import eu.xthedoctah.launcher.auth.Error;
import eu.xthedoctah.launcher.auth.Response;
import eu.xthedoctah.launcher.logger.LogType;
import eu.xthedoctah.launcher.logger.Logger;
import eu.xthedoctah.launcher.model.Profile;
import eu.xthedoctah.launcher.settings.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public JFXPasswordField passwordBox;
    @FXML
    public JFXTextField usernameBox;
    @FXML
    public JFXButton closeButton;
    @FXML
    public CheckBox rememberMe;
    private Logger logger = Logger.getInstance();
    private Boolean isChecked = false;

    @FXML
    public void pressButton(ActionEvent e) {
        try {
            if (e.getSource() instanceof Button) {
                if (Auth.getInstance().doAuth(usernameBox.getText(), passwordBox.getText())) {
                    logger.log(LogType.INFO, "Username: " + Response.getInstance().getSelectedProfile().getName());
                    if (this.isChecked)
                        Settings.getInstance().createUser(new Profile(usernameBox.getText(), passwordBox.getText(), true));
                    Parent launcher = FXMLLoader.load(getClass().getResource("/launcher.fxml"));
                    Stage windows = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    windows.setScene(new Scene(launcher));
                    windows.show();
                } else {
                    logger.log(LogType.ERROR, Error.getInstance().getErrorMessage());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
        usernameBox.setText(Profile.getInstance().getUsername());
        passwordBox.setText(Profile.getInstance().getPassword());
    }
}
