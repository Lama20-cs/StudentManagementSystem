package com.mycompany.studentmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class ViewStudentsController {

    // TableView that displays all students
    @FXML
    private TableView<Student> tableView;

    // Column for student ID
    @FXML
    private TableColumn<Student, String> idColumn;

    // Column for student name
    @FXML
    private TableColumn<Student, String> nameColumn;

    // Column for student email
    @FXML
    private TableColumn<Student, String> emailColumn;

    // Column for student major
    @FXML
    private TableColumn<Student, String> majorColumn;

    // Column for student grade
    @FXML
    private TableColumn<Student, Integer> gradeColumn;

    // Label used to display the average grade
    @FXML
    private Label averageLabel;

    // ObservableList stores students dynamically for the TableView
    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    // This method runs automatically when the page opens
    // It connects each table column with the Student class attributes
    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
    }

    // This method loads students and grades from text files
    // Then displays them inside the table
    @FXML
    private void loadStudents() {

        // Clears old data before loading again
        studentList.clear();

        try {

            // HashMap stores student ID with its grade
            HashMap<String, Integer> gradesMap = new HashMap<>();

            // Opens grades.txt file for reading
            BufferedReader gradeReader = new BufferedReader(new FileReader("grades.txt"));

            String line;

            // Reads grades file line by line
            while ((line = gradeReader.readLine()) != null) {

                // Splits each line using comma
                String[] data = line.split(",");

                // Saves student ID and grade inside HashMap
                gradesMap.put(
                        data[0],
                        Integer.parseInt(data[1]));
            }

            // Closes grades file after reading
            gradeReader.close();

            // Opens students.txt file for reading
            BufferedReader studentReader = new BufferedReader(new FileReader("students.txt"));

            double total = 0;

            int count = 0;

            // Reads students file line by line
            while ((line = studentReader.readLine()) != null) {

                // Splits student data using comma
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String email = data[2];
                String major = data[3];

                // Gets student grade using ID
                // If no grade exists, default value becomes 0
                int grade = gradesMap.getOrDefault(id, 0);

                // Creates Student object
                Student student = new Student(id, name, email, major, grade);

                // Adds student to ObservableList
                studentList.add(student);

                total += grade;

                count++;
            }

            // Closes students file
            studentReader.close();

            // Displays student list inside the table
            tableView.setItems(studentList);

            // Checks if there are students before calculating average
            if (count > 0) {

                // Calculates average grade
                double average = total / count;

                // Displays average grade in label
                averageLabel.setText(
                        "Average Grade: " + average);
            }

        } catch (Exception e) {

            // Prints error details if any problem happens
            e.printStackTrace();
        }
    }

    // This method returns the user back to Dashboard page
    @FXML
    private void goBack() {

        try {

            // Loads Dashboard.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));

            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) tableView.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {

            // Prints error details if scene loading fails
            e.printStackTrace();
        }
    }
}