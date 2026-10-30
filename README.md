# Student Management System

A desktop application for managing student records and grades, built with Java and JavaFX as a university group project (team of 4).

## Features

- **Login:** Secure entry to the system through a login screen.
- **Dashborad:** A central page to choose any action: add a student, add a grade, view the report, or log out.
- **Add Student:** Enter a student's name, ID, email, and major. A confirmation message appears once the student is added.
- **Add Grade:** Assign a grade to an existing student using their ID.
- **View Report:** Displays all students in a table with their name, ID, email, major, and grade. Records can also be deleted from this page.
- **Data Persistence:** All data is saved to an external file, so it is still available the next time the application is opened.

## Technologies

- Java
- JavaFX / FXML
- File-based data storage

## My Contributions

- Built the **View Student** screen (`viewStudents.fxml` and `ViewStudentsController.java`), including the students table and record deletion.
- Developed the **Report** class and `ReportsController.java`, which create and manage the external file where student data is stored.

## Demo Login

- Username: `admin`
- Password: `1234`
