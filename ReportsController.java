package com.mycompany.studentmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReportsController {

    // Label used to display total number of students
    @FXML
    private Label totalStudentsLabel;

    // Label used to display average grade
    @FXML
    private Label averageGradeLabel;

    // This method generates a report from grades.txt
    // It calculates total students and average grade
    @FXML
    private void generateReport() {

        try {

            // Opens grades.txt file for reading
            BufferedReader reader = new BufferedReader(new FileReader("grades.txt"));

            String line;

            int totalStudents = 0;

            double totalGrades = 0;

            // Reads file line by line
            while ((line = reader.readLine()) != null) {

                // Splits line using comma
                String[] data = line.split(",");

                // Converts grade from String to Integer
                int grade = Integer.parseInt(data[1]);

                totalGrades += grade;

                totalStudents++;
            }

            reader.close();

            // Calculates average grade
            double average =
                    totalGrades / totalStudents;

            // Displays total number of students
            totalStudentsLabel.setText(
                    "Total Students: " + totalStudents);

            // Displays average grade
            averageGradeLabel.setText(
                    "Average Grade: " + average);

        } catch (Exception e) {

            // Prints error details if any problem happens
            e.printStackTrace();
        }
    }
}