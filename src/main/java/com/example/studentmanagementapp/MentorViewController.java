package com.example.studentmanagementapp;

import com.example.studentmanagementapp.dataStore.MentorDataStore;
import com.example.studentmanagementapp.objects.Classes;
import com.example.studentmanagementapp.objects.Mentors;
import com.example.studentmanagementapp.objects.Occupation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MentorViewController implements Initializable {
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

    public final static MentorDataStore store = MentorDataStore.getInstance();
    public boolean isOpen = true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //DeleteAction
        btnDelete.setOnAction(e -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            store.mentorNamesList.remove(index);
            store.mentorsList.remove(index);
            tableView.getItems().remove(index);
        });

        tableView.getItems().addAll(store.mentorsList);

        //AddFunction
        btnAdd.setOnAction(e -> {

          if(isOpen) {
              Stage addViewStage = new Stage();
              try {
                  FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("addMentor-view.fxml"));
                  addViewStage.setUserData(this);
                  Parent viewNode = fxmlLoader.load();
                  Scene viewScene = new Scene(viewNode);
                  addViewStage.initStyle(StageStyle.TRANSPARENT);
                  addViewStage.setScene(viewScene);
                  addViewStage.show();
                  isOpen = false;
              } catch (IOException exception) {
                  exception.getStackTrace();
              }
          }
        });
    }

    //AddNewMentor
    public void addNewMentor(String name, String age, String address, Occupation occupation, String fatherName, String nrcNo,  String salary, Classes classes){
        Mentors m = new Mentors();
        m.setName(name);
        m.setAddress(address);
        m.setAge(age);
        m.setOccupation(occupation);
        m.setFatherName(fatherName);
        m.setNrcNo(nrcNo);
        m.setSalary(salary + " Ks");
        m.setClasses(classes);

        store.mentorNamesList.add(m);
        store.mentorsList.add(m);
        tableView.getItems().add(m);
    }
}
