package eu.xthedoctah.launcher;


import eu.xthedoctah.launcher.logger.LogType;
import eu.xthedoctah.launcher.logger.Logger;
import eu.xthedoctah.launcher.settings.Settings;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;


public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        try {
            File file = new File(Settings.workingDir);
            if (!file.exists()) {
                try {
                    file.mkdir();
                } catch (SecurityException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } finally {
            Logger.getInstance().createLog(LogType.INFO, "OS: " +
                    System.getProperty("os.name") +
                    System.getProperty("os.arch") +
                    System.getProperty("os.version"));
        }
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
        primaryStage.setTitle("Whoniverse Launcher");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
