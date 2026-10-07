package com.mycompany.studentmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    // Field for entering the username
    @FXML
    private TextField usernameField;

    // Field for entering the password
    @FXML
    private PasswordField passwordField;

    // Handles the login button action
    @FXML
    private void handleLogin() {
        System.out.println("Button clicked");
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Checks if the username and password are correct
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Correct");
            try {
                // Opens the Dashboard screen after successful login
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong");

            // Shows an error message if login information is wrong
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Wrong username or password");
            alert.showAndWait();
        }
    }
}