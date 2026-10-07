package com.mycompany.studentmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Main Application Class
 * Entry point of the program
 */
public class MainApp extends Application {

    /*
     * Start method
     * Loads Login screen (FXML)
     */
    @Override
    public void start(Stage stage) throws Exception {

        // Load Login FXML
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/views/Login.fxml"));

        // Create scene
        Scene scene = new Scene(loader.load());

        // Set scene to stage
        stage.setScene(scene);

        // Set window title
        stage.setTitle("Student Management System");

        // Show window
        stage.show();
    }

    /*
     * Main method
     * Launches JavaFX application
     */
    public static void main(String[] args) {
        launch(args);
    }
}