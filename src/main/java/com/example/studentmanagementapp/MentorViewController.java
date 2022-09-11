package com.example.studentmanagementapp;

import com.example.studentmanagementapp.dataStore.MentorDataStore;
import com.example.studentmanagementapp.objects.Classes;
import com.example.studentmanagementapp.objects.Mentors;
import com.example.studentmanagementapp.objects.Occupation;
import com.example.studentmanagementapp.objects.Students;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.example.studentmanagementapp.AddMentorViewController.isEditings;
import static com.example.studentmanagementapp.classviewcontrol.ClassViewController.dataStore;

public class MentorViewController implements Initializable {

    @FXML
    Button btnEdit;
    @FXML
    Button btnDelete;
    @FXML
    TableView <Mentors>tableView;
    @FXML
     Button btnAdd;
    @FXML
    TableColumn<String, Mentors> colName;
    @FXML
     TableColumn<String, Mentors> colAge;
    @FXML
    TableColumn<String, Mentors> colAddress;
    @FXML
     TableColumn<Classes, Mentors> colClass;
    @FXML
     TableColumn<String, Mentors> colFatherName;
    @FXML
    TableColumn<Occupation, Mentors> colOccupation;
    @FXML
     TableColumn<Integer, Mentors> colSalary;
    @FXML
    ComboBox<Occupation> cmbJob;
    @FXML
    TextField txtSearch;


    public static MentorDataStore store = MentorDataStore.getInstance();
    private static List<Mentors> mentors = store.mentorsList;
    public boolean isOpen = true;
    public int selectedIndex;
    public Mentors selectedMentor;
    public Occupation selectedJob;
    public Classes selectedClass;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.getItems().addAll(store.mentorsList);

        //SearchFilter
        txtSearch.textProperty().addListener((obj, oldVal, newVal) -> {
            if(!newVal.isEmpty()){
                mentors = store.mentorsList.stream()
                        .filter(mentor -> mentor.getName().toLowerCase().startsWith(newVal.toLowerCase()))
                        .collect(Collectors.toList());
            }else{
                mentors = store.mentorsList;
            }
            resetTableView();
        });

        cmbJob.getItems().addAll(Occupation.occupation);

        //SortFilterJob
        cmbJob.valueProperty().addListener((obj, oldVal, newVal) -> {

            mentors = store.mentorsList.stream().sorted((mentors1, mentors2) -> {
                if (mentors1.getOccupation() == newVal) {
                    return -1;
                } else if (mentors2.getOccupation() == newVal) {
                    return 1;
                }
                return 0;
            }).collect(Collectors.toList());

            resetTableView();
        });



        //AddAction
        btnAdd.setOnAction(e -> {
            isEditings = false;

            if(isOpen) {
                Stage addViewStage = new Stage();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("addMentor-view.fxml"));
                    addViewStage.setUserData(this);
                    Parent viewNode = fxmlLoader.load();
                    Scene viewScene = new Scene(viewNode);
                    viewScene.getStylesheets().add(getClass().getResource("AddMentorView.css").toExternalForm());
                    addViewStage.initStyle(StageStyle.TRANSPARENT);
                    addViewStage.setScene(viewScene);
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
            selectedMentor = tableView.getSelectionModel().getSelectedItem();
            selectedJob = selectedMentor.getOccupation();
            selectedClass = selectedMentor.getClasses();

            if(!(selectedMentor==null) && isOpen) {
                Stage addViewStage = new Stage();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("addMentor-view.fxml"));
                    addViewStage.setUserData(this);
                    Parent viewNode = fxmlLoader.load();
                    Scene viewScene = new Scene(viewNode);
                    viewScene.getStylesheets().add(getClass().getResource("AddMentorView.css").toExternalForm());
                    addViewStage.initStyle(StageStyle.TRANSPARENT);
                    addViewStage.setScene(viewScene);
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
            store.mentorNamesList.remove(index);
            store.mentorsList.remove(index);
            tableView.getItems().remove(index);
        });
    }

    //AddNewMentor
    public void addNewMentor(String name, LocalDate age, String address, Occupation occupation, String nrcNo, String salary, Classes classes){
        Mentors m = new Mentors();
        m.setName(name);
        m.setAddress(address);
        m.setAge(age);
        m.setOccupation(occupation);
        m.setNrcNo(nrcNo);
        m.setSalary(salary + " Ks");
        m.setClasses(classes);

        store.mentorNamesList.add(m);
        store.mentorsList.add(m);
        tableView.getItems().add(m);
    }

    //EditMentor
    public void editMentor(String name, LocalDate age, String address, Occupation occupation, String nrcNo,  String salary,  Classes classes){
        selectedMentor.setName(name);
        selectedMentor.setAddress(address);
        selectedMentor.setAge(age);
        selectedMentor.setOccupation(occupation);
        selectedMentor.setNrcNo(nrcNo);
        selectedMentor.setSalary(salary);
        selectedMentor.setClasses(classes);

        //removingOldValue
        store.mentorsList.remove(selectedIndex);
        store.mentorNamesList.remove(selectedIndex);
        tableView.getItems().clear();
        //settingNewValue
        store.mentorNamesList.add(selectedIndex, selectedMentor);
        store.mentorsList.add(selectedIndex, selectedMentor);
        //addingNewTableView
        tableView.getItems().addAll(store.mentorsList);
    }

    //resetTableView
    private void resetTableView(){
        tableView.getItems().clear();
        tableView.getItems().addAll(mentors);
    }
}

