package com.example.studentmanagementapp.dataStore;

import com.example.studentmanagementapp.objects.Classes;

import java.util.ArrayList;
import java.util.List;

public class ClassDataStore extends Classes {

    public List<Classes> classesList = new ArrayList<>();
    public List<Classes> classesNameList = new ArrayList<>();

    private static ClassDataStore instance;

    public static ClassDataStore getInstance(){
        if(instance == null){
            instance = new ClassDataStore();
        }
        return instance;
    }

    private ClassDataStore(){
         classesList.addAll(Classes.defaultClassesList());
         classesNameList.addAll(Classes.defaultClassesNameList());
    }


}
