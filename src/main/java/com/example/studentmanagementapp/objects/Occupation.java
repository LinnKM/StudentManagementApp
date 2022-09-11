package com.example.studentmanagementapp.objects;

import java.util.List;

public class Occupation {
    private String name;

    public Occupation(String name){
        this.name = name;
    }

    public static List<Occupation> occupation = List.of(
            new Occupation("Engineer"),
            new Occupation("Developer"),
            new Occupation("Teacher"),
            new Occupation("Government-Staff"),
            new Occupation("Doctor"),
            new Occupation("House-wife"),
            new Occupation("Student"),
            new Occupation("Hotel-Chef"),
            new Occupation("Karate-Sensei")
    );

    @Override
    public String toString() {
        return name;
    }
}
