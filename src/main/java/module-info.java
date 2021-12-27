module com.example.studentmanagementapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentmanagementapp to javafx.fxml;
    exports com.example.studentmanagementapp;
    exports com.example.studentmanagementapp.loginviewcontrol;
    opens com.example.studentmanagementapp.loginviewcontrol to javafx.fxml;
    exports com.example.studentmanagementapp.classviewcontrol;
    opens com.example.studentmanagementapp.classviewcontrol to javafx.fxml;
    exports com.example.studentmanagementapp.objects;
    opens com.example.studentmanagementapp.objects to javafx.fxml;
    exports com.example.studentmanagementapp.dataStore;
    opens com.example.studentmanagementapp.dataStore to javafx.fxml;
}