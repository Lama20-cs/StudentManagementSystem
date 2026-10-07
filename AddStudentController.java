package com.mycompany.studentmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddStudentController {

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField majorField;

    @FXML
    private Button backButton;

    @FXML
    private void handleAddStudent() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String major = majorField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || email.isEmpty() || major.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "All fields are required. Please fill in all the data.");
            return;
        }

        Student newStudent = new Student(id, name, email, major);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
            writer.write(newStudent.toString());
            writer.newLine();
            
            showAlert(Alert.AlertType.INFORMATION, "Success", "Student data has been saved successfully!");
            clearFields();
            
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "File Error", "An error occurred while trying to write to the storage file.");
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        emailField.clear();
        majorField.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
