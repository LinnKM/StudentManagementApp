package com.example.studentmanagementapp.objects;

import java.time.LocalDate;
import java.util.List;

public class Students {

    //States
    private String name;
    private LocalDate age;
    private String address;
    private Occupation occupation;
    private String nrcNo;
    private Classes classes;
    private Mentors mentors;

    //DefaultStudents
    public static List<Students> defaultStudentList(){
        return List.of(
                new Students("Aung Ko", LocalDate.of(2000, 1, 10), "North-Okkala", Occupation.occupation.get(6),  "12/222", Classes.defaultClassesList().get(0), Mentors.defaultMentorsList().get(3)),
                new Students("Linn Myat Myat Hein", LocalDate.of(2001, 2, 10), "BotaHtaung", Occupation.occupation.get(6),  "12/333", Classes.defaultClassesList().get(0), Mentors.defaultMentorsList().get(1)),
                new Students("Jhon Win", LocalDate.of(2002, 10, 10), "North-Okkala", Occupation.occupation.get(6),  "12/555", Classes.defaultClassesList().get(0), Mentors.defaultMentorsList().get(3)),
                new Students("Aung Ko Ko Hein", LocalDate.of(1970, 5, 10), "Hlaing", Occupation.occupation.get(5),  "12/554", Classes.defaultClassesList().get(6), Mentors.defaultMentorsList().get(6)),
                new Students("Ko Ko Zaw", LocalDate.of(2003, 4, 10), "San-Chaung", Occupation.occupation.get(6),  "12/224", Classes.defaultClassesList().get(4), Mentors.defaultMentorsList().get(2)),
                new Students("Kyaw Wana", LocalDate.of(1999, 6, 10), "Tamwe", Occupation.occupation.get(6),  "12/344", Classes.defaultClassesList().get(5), Mentors.defaultMentorsList().get(5)),
                new Students("Myo Myo Latt", LocalDate.of(2000, 9, 10), "South-Dagon", Occupation.occupation.get(6),  "12/445", Classes.defaultClassesList().get(7), Mentors.defaultMentorsList().get(7)),
                new Students("Myint Myat Aung", LocalDate.of(2004, 10, 10), "South-Dagon", Occupation.occupation.get(6),  "12/999", Classes.defaultClassesList().get(7), Mentors.defaultMentorsList().get(7))
        );
    }

    //Constructors
    public Students(){

    }
    public Students(String name, LocalDate age, String address, Occupation occupation,  String nrcNo, Classes classes, Mentors mentors){
        this.name = name;
        this.age = age;
        this.address = address;
        this.occupation = occupation;
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

    public List<Classes> getClasses(String id){
        return Classes.defaultClassesList();
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


    public  Occupation getOccupation() {
        return occupation;
    }

    public  void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
