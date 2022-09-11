package com.example.studentmanagementapp;
import com.example.studentmanagementapp.dataStore.StudentDataStore;
import com.example.studentmanagementapp.objects.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.example.studentmanagementapp.AddStudentViewController.isEditingStudent;
import static com.example.studentmanagementapp.MentorViewController.store;
import static com.example.studentmanagementapp.classviewcontrol.ClassViewController.dataStore;

public class StudentViewController implements Initializable {
    @FXML
    TextField txtSearch;
    @FXML
    Button btnEdit;
    @FXML
    Button btnAdd;
    @FXML
    Button btnDelete;
    @FXML
    private TableColumn<String, Students> colAddress;
    @FXML
    private TableColumn<String, Students> colAge;
    @FXML
    private TableColumn<String, Students> colClass;
    @FXML
    private TableColumn<String, Students> colFatherName;
    @FXML
    private TableColumn<String, Students> colMentor;
    @FXML
    private TableColumn<String, Students> colNRC;
    @FXML
    private TableColumn<String, Students> colName;
    @FXML
    private TableColumn<String, Students> colOccupation;
    @FXML
    private TableView<Students> tableView;
    @FXML
     ComboBox <Occupation> cmbJob;




    private final static StudentDataStore store1 = StudentDataStore.getInstance();
    private static List<Students> students = store1.studentsList;
    public boolean isOpen = true;
    public int selectedIndex;
    public Students selectedStudent;
    public Occupation selectedJob;
    public Mentors selectedMentor;
    public Classes selectedClass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableView.getItems().addAll(students);

        //SearchFilter
        txtSearch.textProperty().addListener((obj, oldVal, newVal) -> {
            if (!newVal.isEmpty()) {
                students = store1.studentsList.stream()
                        .filter(student -> student.getName().toLowerCase().startsWith(newVal.toLowerCase()))
                        .collect(Collectors.toList());
            } else {
                students = store1.studentsList;
            }

            resetTableView();
        });

        settingComboBoxValues();

        //SortFilterJob
        cmbJob.valueProperty().addListener((obj, oldVal, newVal) -> {

            students = store1.studentsList.stream().sorted((student1, student2) -> {
                if (student1.getOccupation() == newVal) {
                    return -1;
                } else if (student2.getOccupation() == newVal) {
                    return 1;
                }
                return 0;
            }).collect(Collectors.toList());

            resetTableView();
        });




        //Add Action
        btnAdd.setOnAction(e -> {
          isEditingStudent = false;
          if(isOpen) {
              Stage addViewStage = new Stage();
              try {
                  addViewStage.setUserData(this);
                  FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("addStudent-view.fxml"));
                  Parent viewNode = fxmlLoader.load();
                  Scene viewScene = new Scene(viewNode);
                  viewScene.getStylesheets().add(getClass().getResource("AddStudentView.css").toExternalForm());
                  addViewStage.setScene(viewScene);
                  addViewStage.initStyle(StageStyle.TRANSPARENT);
                  addViewStage.show();
                  isOpen = false;

              } catch (IOException exception) {
                  exception.getStackTrace();
              }
          }
        });

        //EditAction
        btnEdit.setOnAction(e -> {
            selectedIndex = tableView.getSelectionModel().getSelectedIndex();
            selectedStudent = tableView.getSelectionModel().getSelectedItem();
            selectedJob = selectedStudent.getOccupation();
            selectedMentor = selectedStudent.getMentors();
            selectedClass = selectedStudent.getClasses();

            if(!(selectedStudent==null) && isOpen) {
                Stage addViewStage = new Stage();
                try {
                    addViewStage.setUserData(this);
                    FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("addStudent-view.fxml"));
                    Parent viewNode = fxmlLoader.load();
                    Scene viewScene = new Scene(viewNode);
                    viewScene.getStylesheets().add(getClass().getResource("AddStudentView.css").toExternalForm());
                    addViewStage.setScene(viewScene);
                    addViewStage.initStyle(StageStyle.TRANSPARENT);
                    addViewStage.show();
                    isOpen = false;

                } catch (IOException exception) {
                    exception.getStackTrace();
                }
            }
        });

        //DeleteAction
        btnDelete.setOnAction(e -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            store1.studentsList.remove(index);
            tableView.getItems().remove(index);
        });

    }

    //AddNewStudent
    public void addNewStudent(String name, LocalDate age, String address, Occupation occupation,  String nrcNo, Classes classes, Mentors mentors){
        Students m = new Students();
        m.setName(name);
        m.setAddress(address);
        m.setAge(age);
        m.setOccupation(occupation);
        m.setNrcNo(nrcNo);
        m.setClasses(classes);
        m.setMentors(mentors);

        store1.studentsList.add(m);
        tableView.getItems().add(m);
    }

    //EditStudent
    public void editStudent(String name, LocalDate age, String address, Occupation occupation,  String nrcNo, Classes classes, Mentors mentors){
        selectedStudent.setName(name);
        selectedStudent.setAddress(address);
        selectedStudent.setAge(age);
        selectedStudent.setOccupation(occupation);
        selectedStudent.setNrcNo(nrcNo);
        selectedStudent.setClasses(classes);
        selectedStudent.setMentors(mentors);

        //removingOldValue
        store1.studentsList.remove(selectedIndex);
        tableView.getItems().clear();
        //settingNewValue
        store1.studentsList.add(selectedIndex, selectedStudent);
        //addingNewTableView
        tableView.getItems().addAll(store1.studentsList);
    }

    //resetTableView
    private void resetTableView(){
        tableView.getItems().clear();
        tableView.getItems().addAll(students);
    }

    private void settingComboBoxValues(){
        cmbJob.getItems().addAll(Occupation.occupation);
    }
}
