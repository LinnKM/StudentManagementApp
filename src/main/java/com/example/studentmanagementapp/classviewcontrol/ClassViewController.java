package com.example.studentmanagementapp.classviewcontrol;

import com.example.studentmanagementapp.ManagementApplication;
import com.example.studentmanagementapp.dataStore.ClassDataStore;
import com.example.studentmanagementapp.objects.Classes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassViewController implements Initializable {
    @FXML
     TableColumn<String, Classes> classNameColon;

    @FXML
     TableView<Classes> classTableView;

    @FXML
     TableColumn<String, Classes> feeColon;

    @FXML
     Button btnDelete;
    @FXML
     Button BtnEdit;
    @FXML
     Button btnSave;
    @FXML
     TextField txtClassFee;
    @FXML
     TextField txtClassName;

    public boolean isOpen = true;
    public static final ClassDataStore dataStore = ClassDataStore.getInstance();

    public int selectedIndex;
    public Classes selectedClass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //SaveAction
        btnSave.setOnAction(e -> {
            Classes aClass = new Classes();
            aClass.setClassName(txtClassName.getText().isEmpty() ? "Anonymous" : txtClassName.getText());
            aClass.setClassFee(txtClassFee.getText() + " Ks");

            dataStore.classesList.add(aClass);
            dataStore.classesNameList.add(aClass);
            classTableView.getItems().add(aClass);

            reset();
        });

        //DeleteAction
        btnDelete.setOnAction(e -> {
            int index = classTableView.getSelectionModel().getSelectedIndex();
            dataStore.classesNameList.remove(index);
            dataStore.classesList.remove(index);
            classTableView.getItems().remove(index);
        });

        //EditAction
        BtnEdit.setOnAction(e -> {
            selectedIndex = classTableView.getSelectionModel().getSelectedIndex();
            selectedClass = classTableView.getSelectionModel().getSelectedItem();

          if(!(selectedClass == null) && isOpen) {
              try {
                  Stage editStage = new Stage();
                  FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("editClass.fxml"));

                  editStage.setUserData(dataStore);
                  editStage.setUserData(this);

                  Parent editNode = fxmlLoader.load();
                  Scene editScene = new Scene(editNode);
                  editStage.setScene(editScene);
                  editStage.setUserData(this);
                  editStage.show();
                  isOpen = false;
              } catch (IOException exception) {
                  exception.getStackTrace();
              }
          }
        });

        //DefaultData
        classTableView.getItems().addAll(dataStore.classesList);
    }


    //EditingMethod
    public void isEditing(String className, String classFee){
        selectedClass.setClassName(className);
        selectedClass.setClassFee(classFee);

        //removingOldValue
        dataStore.classesList.remove(selectedIndex);
        dataStore.classesNameList.remove(selectedIndex);
        classTableView.getItems().clear();
        //settingNewValue
        dataStore.classesList.add(selectedIndex, selectedClass);
        dataStore.classesNameList.add(selectedIndex, selectedClass);
        //addingNewTableView
        classTableView.getItems().addAll(dataStore.classesList);
    }

    public String setClassName(){
        return selectedClass.getClassName();
    }

    public String setClassFee(){
        return selectedClass.getClassFee();
    }

    //ResetMethod
    private void reset(){
        txtClassName.clear();
        txtClassFee.clear();
    }
}
