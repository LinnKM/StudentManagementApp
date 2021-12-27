package com.example.studentmanagementapp.objects;

import java.util.List;

public class Mentors {

    //States
    private String name;
    private String age;
    private String address;
    private static Occupation occupation;
    private String fatherName;
    private String nrcNo;
    private Classes classes;
    private String salary;

    //DefaultMentorList
    public static List<Mentors> defaultMentorsList(){
        return List.of(
                new Mentors("Mg Mg", "18", "Yangon", Occupation.occupation.get(0), "U Tun", "12/334", "13000",Classes.defaultClassesList().get(1))
        );
    }
    public static List<Mentors> defaultMentorNameList(){
       return List.of(
               new Mentors("Mg Mg")
       );
    }


    //MentorConstructors
    public Mentors(){}
    public Mentors(String name){
        this.name = name;
    }
    public Mentors(String name, String age, String address, Occupation occupation, String fatherName, String nrcNo,  String salary,  Classes classes){
        this.name = name;
        this.age = age;
        this.address = address;
        Mentors.occupation = occupation;
        this.fatherName = fatherName;
        this.nrcNo = nrcNo;
        this.salary = salary;
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

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses( Classes classes) {
        this.classes = classes;
    }

    //ToStringMethod

    @Override
    public String toString() {
       return name;
    }
}
