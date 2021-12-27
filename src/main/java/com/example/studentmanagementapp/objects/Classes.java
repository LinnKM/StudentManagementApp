package com.example.studentmanagementapp.objects;

import java.util.List;

public class Classes {
    private String className;
    private String classFee;

    //Constructors
    public Classes(){

    }
    public Classes(String className, String classFee){
        this.classFee = classFee;
        this.className = className;
    }
    public Classes(String className){
        this.className = className;
    }

    public static List<Classes> defaultClassesList(){
        return List.of(
                new Classes("Programming Class", "250000 Ks"),
                new Classes("Swimming Class", "50000 Ks")
        );
    }

    public static List<Classes> defaultClassesNameList(){
        return List.of(
                new Classes("Programming Class"),
                new Classes("Swimming Class")
        );
    }


    //Getters and Setters
    public String getClassFee() {
        return classFee;
    }

    public void setClassFee(String classFee) {
        this.classFee = classFee;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return className;
    }
}
