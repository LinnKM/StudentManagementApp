package com.example.studentmanagementapp.objects;

import java.util.List;

public class Students {

    //States
    private String name;
    private String age;
    private String address;
    private static Occupation occupation;
    private String fatherName;
    private String nrcNo;
    private Classes classes;
    private Mentors mentors;

    //DefaultStudents
    public static List<Students> defaultStudentList(){
        return List.of(
                new Students("Aung Ko", "18", "Mandalay", Occupation.occupation.get(0), "U Nyein", "12333", Classes.defaultClassesNameList().get(0), Mentors.defaultMentorNameList().get(0))
        );
    }

    //Constructors
    public Students(){

    }
    public Students(String name, String age, String address, Occupation occupation, String fatherName, String nrcNo, Classes classes, Mentors mentors){
        this.name = name;
        this.age = age;
        this.address = address;
        Students.occupation = occupation;
        this.fatherName = fatherName;
        this.nrcNo = nrcNo;
        this.classes = classes;
        this.mentors = mentors;
    }

    //Getters And Setters
    public Mentors getMentors() {
        return mentors;
    }

    public void setMentors(Mentors mentors) {
        this.mentors = mentors;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getNrcNo() {
        return nrcNo;
    }

    public void setNrcNo(String nrcNo) {
        this.nrcNo = nrcNo;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public static Occupation getOccupation() {
        return occupation;
    }

    public static void setOccupation(Occupation occupation) {
        Students.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
