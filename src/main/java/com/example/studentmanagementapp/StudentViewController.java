package com.example.studentmanagementapp;
import com.example.studentmanagementapp.dataStore.StudentDataStore;
import com.example.studentmanagementapp.objects.Classes;
import com.example.studentmanagementapp.objects.Mentors;
import com.example.studentmanagementapp.objects.Occupation;
import com.example.studentmanagementapp.objects.Students;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

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

    private final static StudentDataStore store = StudentDataStore.getInstance();
    public boolean isOpen = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        tableView.getItems().addAll(store.studentsList);

        btnAdd.setOnAction(e -> {

          if(isOpen) {
              Stage addViewStage = new Stage();
              try {
                  addViewStage.setUserData(this);
                  FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("addStudent-view.fxml"));
                  Parent viewNode = fxmlLoader.load();
                  Scene viewScene = new Scene(viewNode);
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
            store.studentsList.remove(index);
            tableView.getItems().remove(index);
        });

    }
    //AddNewStudent
    public void addNewStudent(String name, String age, String address, Occupation occupation, String fatherName, String nrcNo, Classes classes, Mentors mentors){
        Students m = new Students();
        m.setName(name);
        m.setAddress(address);
        m.setAge(age);
        Students.setOccupation(occupation);
        m.setFatherName(fatherName);
        m.setNrcNo(nrcNo);
        m.setClasses(classes);
        m.setMentors(mentors);

        store.studentsList.add(m);
        tableView.getItems().add(m);
    }
}
