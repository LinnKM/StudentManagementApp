package com.example.studentmanagementapp.dataStore;

import com.example.studentmanagementapp.objects.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentDataStore {

    public List<Students> studentsList = new ArrayList<>();
    private static StudentDataStore instance;

    public static StudentDataStore getInstance(){
        if(instance == null){
            instance = new StudentDataStore();
        }
        return instance;
    }

    private StudentDataStore(){
        studentsList.addAll(Students.defaultStudentList());
    }
}
