package com.example.studentmanagementapp;

import com.example.studentmanagementapp.objects.Classes;
import com.example.studentmanagementapp.objects.Occupation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    @FXML
    Label lblHeading;

    public static boolean isEditings = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxJob.getItems().addAll(occupation);
        comboBoxJob.getSelectionModel().select(0);

        comboBoxClass.getItems().addAll(dataStore.classesList);
        comboBoxClass.getSelectionModel().select(0);

        //IfEditing
        if(isEditings){
            btnSave.setText("Edit");
            lblHeading.setText("Edit Mentor");
        //IfAdding
        }else if(!isEditings){
            btnSave.setText("Save");
            lblHeading.setText("Add Mentor");
        }

        //Save Action
        btnSave.setOnAction(e -> {
            if(!isEditings){
                Stage currentStage = (Stage)btnSave.getScene().getWindow();
                MentorViewController mentorViewController = (MentorViewController) currentStage.getUserData();

                mentorViewController.addNewMentor(txtName.getText(),
                        datePicker.getValue(),
                        txtAddress.getText(),
                        comboBoxJob.getSelectionModel().getSelectedItem(),
                        txtNRCno.getText(),
                        txtSalary.getText(),
                        comboBoxClass.getSelectionModel().getSelectedItem()
                );
                mentorViewController.isOpen = true;
                isEditings = true;
                currentStage.close();
            }else if(isEditings){
                if(btnSave.getText().equals("Edit")){
                   Stage currentStage = (Stage) btnSave.getScene().getWindow();
                   MentorViewController mentorViewController = (MentorViewController) currentStage.getUserData();

                   //settingOriginalValue
                   txtName.setText(mentorViewController.selectedMentor.getName());
                   txtSalary.setText(mentorViewController.selectedMentor.getSalary());
                   txtNRCno.setText(mentorViewController.selectedMentor.getNrcNo());
                   txtAddress.setText(mentorViewController.selectedMentor.getAddress());
                   datePicker.setValue(mentorViewController.selectedMentor.getAge());
                   //comboBoxJob.getSelectionModel().select(mentorViewController.selectedJob);
                   //comboBoxClass.getSelectionModel().select(mentorViewController.selectedClass);

                   btnSave.setText("Save");
                }
                else if(btnSave.getText().equals("Save") && isEditings){
                    Stage currentStage = (Stage) btnSave.getScene().getWindow();
                    MentorViewController mentorViewController = (MentorViewController) currentStage.getUserData();

                    //settingNewValue
                    mentorViewController.editMentor(txtName.getText(), datePicker.getValue(), txtAddress.getText(), comboBoxJob.getSelectionModel().getSelectedItem(), txtNRCno.getText(), txtSalary.getText(), comboBoxClass.getSelectionModel().getSelectedItem());
                    mentorViewController.isOpen = true;
                    currentStage.close();
                }

            }
        });

        //Cancel Action
        btnCancel.setOnAction(e -> {
            Stage currentStage = (Stage)btnCancel.getScene().getWindow();
            MentorViewController mentorViewController = (MentorViewController) currentStage.getUserData();
            mentorViewController.isOpen = true;
            isEditings = true;
            currentStage.close();
        });

    }

}
