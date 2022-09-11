package com.example.studentmanagementapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuViewController implements Initializable {
    @FXML
    StackPane stackPane;
    @FXML
    HBox hBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("students.fxml"));
        try{
            Parent studentsNode = fxmlLoader.load();
            stackPane.getChildren().clear();
            stackPane.getChildren().add(studentsNode);
        }catch (IOException e){
            e.getStackTrace();
        }

        hBox.getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .forEach(button -> {
                      button.setOnAction(event -> {
                          menuEventHandler(button.getText(), event);
                      });
                });
    }

    //MenuEventHandling
    private void menuEventHandler(String resourceName, ActionEvent e){
        switch(resourceName){
            case "Students" :
                System.out.println("Show Students");
                loadView("students");
                break;

            case "Classes" :
                loadView("class");
                System.out.println("Show Classes");
                break;

            case "Mentors" :
                loadView("mentors");
                System.out.println("Mentors");
                break;
            default:
                System.out.println("Invalid");
        }
    }

    //LoadViewMethod
    private void loadView(String resourceName){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource(resourceName + ".fxml"));
            Parent currentViewNode = fxmlLoader.load();

            stackPane.getChildren().clear();
            stackPane.getChildren().add(currentViewNode);
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}
