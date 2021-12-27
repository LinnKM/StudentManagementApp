package com.example.studentmanagementapp;

import com.example.studentmanagementapp.objects.Classes;
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

import static com.example.studentmanagementapp.objects.Occupation.occupation;
import static com.example.studentmanagementapp.classviewcontrol.ClassViewController.dataStore;

public class AddMentorViewController implements Initializable {
    @FXML
    ComboBox<Classes> comboBoxClass;

    @FXML
    ComboBox<Occupation> comboBoxJob;

    @FXML
    TextField txtAddress;

    @FXML
    DatePicker datePicker;

    @FXML
    TextField txtFatherName;

    @FXML
    TextField txtNRCno;

    @FXML
    TextField txtName;

    @FXML
    TextField txtSalary;

    @FXML
    Button btnSave;

    @FXML
    Button btnCancel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxJob.getItems().addAll(occupation);
        comboBoxJob.getSelectionModel().select(0);

        comboBoxClass.getItems().addAll(dataStore.classesNameList);
        comboBoxClass.getSelectionModel().select(0);

        //Save Action
        btnSave.setOnAction(e -> {
            Stage currentStage = (Stage)btnSave.getScene().getWindow();
            MentorViewController mentorViewController = (MentorViewController) currentStage.getUserData();

            mentorViewController.addNewMentor(txtName.getText(),
                    datePicker.getValue().toString(),
                    txtAddress.getText(),
                    comboBoxJob.getSelectionModel().getSelectedItem(),
                    txtFatherName.getText(),
                    txtNRCno.getText(),
                    txtSalary.getText(),
                    comboBoxClass.getSelectionModel().getSelectedItem()
            );
            mentorViewController.isOpen = true;
            currentStage.close();
        });

        //Cancel Action
        btnCancel.setOnAction(e -> {
            Stage currentStage = (Stage)btnCancel.getScene().getWindow();
            MentorViewController mentorViewController = (MentorViewController) currentStage.getUserData();
            mentorViewController.isOpen = true;
            currentStage.close();
        });

    }

}
