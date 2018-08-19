package eu.xthedoctah.launcher;


import eu.xthedoctah.launcher.settings.Settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        Settings.getInstance().onInit();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });
            primaryStage.setTitle("Whoniverse Launcher");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
