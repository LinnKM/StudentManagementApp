package com.example.studentmanagementapp.objects;

import java.time.LocalDate;
import java.util.List;

public class Mentors {

    //States
    private String name;
    private LocalDate age;
    private String address;
    private Occupation occupation;
    private String nrcNo;
    private Classes classes;
    private String salary;

    //DefaultMentorList
    public static List<Mentors> defaultMentorsList(){
        return List.of(
                new Mentors("Kyaw Lwin", LocalDate.of(2003, 10, 8), "Tamwe", Occupation.occupation.get(1), "12/334", "13000 Ks",Classes.defaultClassesList().get(0)),
                new Mentors("Thein Mg", LocalDate.of(2000, 10, 1), "BotaHtaung", Occupation.occupation.get(0), "12/100", "15000 Ks", Classes.defaultClassesList().get(0)),
                new Mentors("Zaw Hein", LocalDate.of(1950, 3, 10), "South-Okkala", Occupation.occupation.get(2), "12/355", "50000 Ks", Classes.defaultClassesList().get(4)),
                new Mentors("Thia Zaw", LocalDate.of(1989, 3, 8), "BotaHtaung", Occupation.occupation.get(1), "12/540", "50000 Ks", Classes.defaultClassesList().get(0)),
                new Mentors("Lwim Htoo Aung", LocalDate.of(1999, 7, 15), "San-Chaung", Occupation.occupation.get(2), "12/444", "54000 Ks", Classes.defaultClassesList().get(1)),
                new Mentors("Su Yadanar", LocalDate.of(1992, 10, 1), "North-Dagon", Occupation.occupation.get(4), "12/111", "300000 Ks", Classes.defaultClassesList().get(5)),
                new Mentors("Hnin Ei Kyaw", LocalDate.of(2000, 12, 30), "South-Okkala", Occupation.occupation.get(7), "12/754", "250000 Ks", Classes.defaultClassesList().get(6)),
                new Mentors("Kaung Myint Hlaing", LocalDate.of(1950, 4, 10), "Hlaing", Occupation.occupation.get(8), "12/290", "50000 Ks", Classes.defaultClassesList().get(7)),
                new Mentors("Su Myat Khin", LocalDate.of(1985, 3, 11), "YanKin", Occupation.occupation.get(2), "12/594", "45000 Ks", Classes.defaultClassesList().get(3))
        );
    }
    public static List<Mentors> defaultMentorNameList(){
       return List.of(
               new Mentors("Kyaw Lwin"),
               new Mentors("Thein Mg"),
               new Mentors("Zaw Hein"),
               new Mentors("Thia Zaw"),
               new Mentors("Lwim Htoo Aung"),
               new Mentors("Su Yadanar"),
               new Mentors("Hnin Ei Kyaw"),
               new Mentors("Kaung Myint Hlaing"),
               new Mentors("Su Myat Khin")
       );
    }
    //MentorConstructors
    public Mentors(){}
    public Mentors(String name){
        this.name = name;
    }
    public Mentors(String name, LocalDate age, String address, Occupation occupation, String nrcNo,  String salary,  Classes classes){
        this.name = name;
        this.age = age;
        this.address = address;
        this.occupation = occupation;
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

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
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
