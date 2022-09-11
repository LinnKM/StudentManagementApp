package com.example.studentmanagementapp;

import com.example.studentmanagementapp.objects.Classes;
import com.example.studentmanagementapp.objects.Mentors;
import com.example.studentmanagementapp.objects.Occupation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
    TextField txtNRC;
    @FXML
    TextField txtName;
    @FXML
    Button btnSave;
    @FXML
    Button btnCancel;
    @FXML
    Label lblHeading;

    public static boolean isEditingStudent = true;
    public static List<Mentors> mentors = store.mentorsList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

           comboBoxJob.getItems().addAll(Occupation.occupation);
           comboBoxJob.getSelectionModel().select(0);

           comboBoxClass.getItems().addAll(dataStore.classesList);
           comboBoxClass.getSelectionModel().select(0);

           comboBoxMentor.getItems().addAll(mentors);
           comboBoxMentor.getSelectionModel().select(0);


          if(isEditingStudent){
            btnSave.setText("Edit");
            lblHeading.setText("Edit Student");
            //IfAdding
          }else if(!isEditingStudent){
            btnSave.setText("Save");
            lblHeading.setText("Add Student");
          }

           //SaveAction
           btnSave.setOnAction(e -> {

             if(!isEditingStudent) {
                Stage currentStage = (Stage) btnSave.getScene().getWindow();
                StudentViewController studentViewController = (StudentViewController) currentStage.getUserData();

                studentViewController.addNewStudent(
                        txtName.getText(),
                        datePicker.getValue(),
                        txtAddress.getText(),
                        comboBoxJob.getSelectionModel().getSelectedItem(),
                        txtNRC.getText(),
                        comboBoxClass.getSelectionModel().getSelectedItem(),
                        comboBoxMentor.getSelectionModel().getSelectedItem()
                );
                studentViewController.isOpen = true;
                isEditingStudent = true;
                currentStage.close();
             }else if(isEditingStudent){
                 if(btnSave.getText().equals("Edit")){
                     Stage currentStage = (Stage) btnSave.getScene().getWindow();
                     StudentViewController studentViewController = (StudentViewController) currentStage.getUserData();

                     //settingOriginalValue
                     txtName.setText(studentViewController.selectedStudent.getName());
                     txtNRC.setText(studentViewController.selectedStudent.getNrcNo());
                     txtAddress.setText(studentViewController.selectedStudent.getAddress());
                     datePicker.setValue(studentViewController.selectedStudent.getAge());
                     //comboBoxJob.getSelectionModel().select(studentViewController.selectedJob);
                     //comboBoxClass.getSelectionModel().select(studentViewController.selectedClass);
                     //comboBoxMentor.getSelectionModel().select(studentViewController.selectedMentor);

                     btnSave.setText("Save");
                 }else if(btnSave.getText().equals("Save") && isEditingStudent){
                     Stage currentStage = (Stage) btnSave.getScene().getWindow();
                     StudentViewController studentViewController = (StudentViewController) currentStage.getUserData();

                     studentViewController.editStudent(txtName.getText(), datePicker.getValue(), txtAddress.getText(), comboBoxJob.getSelectionModel().getSelectedItem(), txtNRC.getText(), comboBoxClass.getSelectionModel().getSelectedItem(), comboBoxMentor.getSelectionModel().getSelectedItem());

                     studentViewController.isOpen = true;
                     currentStage.close();
                 }
             }
           });

           //CancelAction
           btnCancel.setOnAction(e -> {
               Stage currentStage = (Stage) btnCancel.getScene().getWindow();
               StudentViewController studentViewController = (StudentViewController) currentStage.getUserData();
               studentViewController.isOpen = true;
               isEditingStudent = true;
               currentStage.close();
           });
    }

    private void reloadMentorBox(){
        comboBoxMentor.getItems().clear();
        comboBoxMentor.getItems().addAll(mentors);
    }
}
