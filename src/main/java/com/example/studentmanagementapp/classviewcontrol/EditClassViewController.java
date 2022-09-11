package com.example.studentmanagementapp.classviewcontrol;

import com.example.studentmanagementapp.classviewcontrol.ClassViewController;
import com.example.studentmanagementapp.objects.Classes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditClassViewController implements Initializable {
    @FXML
      Button btnCancel;

    @FXML
      TextField txtEditClass;

    @FXML
      TextField txtEditFee;

    @FXML
    Button BtnEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //EditAction
        BtnEdit.setOnAction(e -> {
            if(BtnEdit.getText().equals("Edit")) {
                Stage editStage = (Stage) BtnEdit.getScene().getWindow();
                ClassViewController cViewController = (ClassViewController) editStage.getUserData();

                txtEditClass.setText(cViewController.selectedClass.getClassName());
                txtEditFee.setText(cViewController.selectedClass.getClassFee());

                BtnEdit.setText("Save");
            }else if(BtnEdit.getText().equals("Save")){
                Stage currentStage = (Stage) BtnEdit.getScene().getWindow();
                ClassViewController classViewController = (ClassViewController) currentStage.getUserData();

                classViewController.isEditing(txtEditClass.getText(), txtEditFee.getText());

                classViewController.isOpen = true;
                currentStage.close();
            }
        });

        //SaveAction
        btnCancel.setOnAction(e -> {
            Stage currentStage = (Stage) btnCancel.getScene().getWindow();
            ClassViewController classViewController = (ClassViewController) currentStage.getUserData();

            classViewController.isOpen = true;
            currentStage.close();

        });


    }
}
