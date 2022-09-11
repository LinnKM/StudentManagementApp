package com.example.studentmanagementapp.loginviewcontrol;

import com.example.studentmanagementapp.ManagementApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    @FXML
     ImageView exitIcon;
    @FXML
    Button BtnLogin;
    @FXML
    TextField TxtUsername;
    @FXML
    TextField TxtPassword;
    @FXML
    Label lblInvalidUsername;
    @FXML
    Label lblInvalidPassword;

    //AdminObject
    private final Admin admin = new Admin("linkk@345", "12345");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //OnclickAction
        BtnLogin.setOnAction(e -> {

            //ConditionWhenLoginSuccess
            if(TxtUsername.getText().equals(admin.getUsername()) && TxtPassword.getText().equals(admin.getPassword())){
                resetTexts();
                //Close currentStage
                Button btnClicked = (Button) e.getSource();
                Stage currentStage = (Stage) btnClicked.getScene().getWindow();
                currentStage.close();

                //Open homepage
                Stage newStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(ManagementApplication.class.getResource("menu-view.fxml"));
                try{
                    Parent homeNode = fxmlLoader.load();
                    Scene scene = new Scene(homeNode);
                    scene.getStylesheets().add(ManagementApplication.class.getResource("Style.css").toExternalForm());
                    scene.getStylesheets().add(ManagementApplication.class.getResource("StudentViewStyle.css").toExternalForm());
                    scene.getStylesheets().add(ManagementApplication.class.getResource("ClassViewStyle.css").toExternalForm());
                    scene.getStylesheets().add(ManagementApplication.class.getResource("MentorViewStyle.css").toExternalForm());

                    newStage.setScene(scene);
                    newStage.show();
                }catch (IOException exception){
                    exception.getStackTrace();
                }
            }

            //ConditionWhenLoginFail
            if(!TxtUsername.getText().equals(admin.getUsername()) || !TxtPassword.getText().equals(admin.getPassword())) {
                if(!TxtUsername.getText().equals(admin.getUsername())){
                    lblInvalidUsername.setText("Incorrect Username");
                    TxtUsername.clear();
                }else if(TxtUsername.getText().equals(admin.getUsername())) {
                    lblInvalidUsername.setText("");
                }if(!TxtPassword.getText().equals(admin.getPassword())){
                    lblInvalidPassword.setText("Incorrect Password");
                    TxtPassword.clear();
                }else if(TxtPassword.getText().equals(admin.getPassword())){
                    lblInvalidPassword.setText("");
                }
            }
        });

        //ExitButton
        exitIcon.setOnMouseClicked(e -> {
            System.exit(0);
        });
    }

    //ResetTexts
    private void resetTexts(){
        TxtUsername.clear();
        TxtPassword.clear();
        lblInvalidPassword.setText("");
        lblInvalidUsername.setText("");
    }
}
