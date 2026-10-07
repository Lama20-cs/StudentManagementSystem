package com.mycompany.studentmanagementsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class DashboardController {

    // Button used to navigate to the Add Student page
    @FXML
    private Button addStudentButton;

    // Opens the Add Student screen
    @FXML
    private void openAddStudent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AddStudent.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) addStudentButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Opens the Add Grades screen
    @FXML
    private void openAddGrades() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AddGrades.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) addStudentButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Opens the View Students screen
    @FXML
    private void openViewStudents() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ViewStudents.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) addStudentButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Logs out the user and returns to the Login screen
    @FXML
    private void logout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) addStudentButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Opens the Add Grades screen using an ActionEvent
    @FXML
    private void openAddGrades(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/AddGrades.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}