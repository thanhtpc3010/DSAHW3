package com.example.dsahw3;

import Entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField scoreField;

    @FXML
    private ListView<String> studentListView;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void onAddButtonClick() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            double score = Double.parseDouble(scoreField.getText());

            Student student = new Student(name, age, score);
            studentList.add(student);
            updateListView();

            // Xóa dữ liệu sau khi thêm
            nameField.clear();
            ageField.clear();
            scoreField.clear();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vui lòng nhập đúng định dạng!");
            alert.showAndWait();
        }
    }

    @FXML
    public void onSortButtonClick() {
        Student[] studentsArray = studentList.toArray(new Student[0]);
        SelectionSort.sort(studentsArray);
        studentList.setAll(studentsArray);
        updateListView();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Danh sách đã được sắp xếp!");
        alert.showAndWait();
    }

    private void updateListView() {
        ObservableList<String> displayList = FXCollections.observableArrayList();
        for (Student student : studentList) {
            displayList.add(student.toString());
        }
        studentListView.setItems(displayList);
    }
}
