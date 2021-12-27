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
            new Occupation("Teacher")
    );

    @Override
    public String toString() {
        return name;
    }
}
