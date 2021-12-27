package com.example.studentmanagementapp;

import com.example.studentmanagementapp.objects.Classes;
import com.example.studentmanagementapp.objects.Mentors;
import com.example.studentmanagementapp.objects.Occupation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.studentmanagementapp.MentorViewController.store;
import static com.example.studentmanagementapp.classviewcontrol.ClassViewController.dataStore;

public class AddStudentViewController implements Initializable {
    @FXML
    ComboBox<Classes> comboBoxClass;

    @FXML
    ComboBox<Occupation> comboBoxJob;

    @FXML
    ComboBox<Mentors> comboBoxMentor;

    @FXML
    DatePicker datePicker;

    @FXML
    TextField txtAddress;

    @FXML
    TextField txtFatherName;

    @FXML
    TextField txtNRC;

    @FXML
    TextField txtName;
    @FXML
    Button btnSave;

    @FXML
    Button btnCancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

           comboBoxClass.getSelectionModel().selectedItemProperty().addListener((v, oldvalue, newvalue) -> {

           });

           comboBoxJob.getItems().addAll(Occupation.occupation);
           comboBoxJob.getSelectionModel().select(0);

           comboBoxClass.getItems().addAll(dataStore.classesNameList);
           comboBoxClass.getSelectionModel().select(0);

           comboBoxMentor.getItems().addAll(store.mentorNamesList);
           comboBoxMentor.getSelectionModel().select(0);

           //SaveAction
           btnSave.setOnAction(e -> {
               Stage currentStage = (Stage) btnSave.getScene().getWindow();
               StudentViewController studentViewController = (StudentViewController) currentStage.getUserData();

               studentViewController.addNewStudent(
                       txtName.getText(),
                       datePicker.getValue().toString(),
                       txtAddress.getText(),
                       comboBoxJob.getSelectionModel().getSelectedItem(),
                       txtFatherName.getText(),
                       txtNRC.getText(),
                       comboBoxClass.getSelectionModel().getSelectedItem(),
                       comboBoxMentor.getSelectionModel().getSelectedItem()
               );
               studentViewController.isOpen = true;
               currentStage.close();
           });

           //CancelAction
           btnCancel.setOnAction(e -> {
               Stage currentStage = (Stage) btnCancel.getScene().getWindow();
               StudentViewController studentViewController = (StudentViewController) currentStage.getUserData();
               studentViewController.isOpen = true;
               currentStage.close();
           });

    }
}
