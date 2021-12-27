package com.example.studentmanagementapp.dataStore;

import com.example.studentmanagementapp.objects.Mentors;

import java.util.ArrayList;
import java.util.List;

public class MentorDataStore {
    public List<Mentors> mentorsList = new ArrayList<>();
    public List<Mentors> mentorNamesList = new ArrayList<>();

    private static MentorDataStore instance;

    public static MentorDataStore getInstance(){
        if(instance == null){
            instance = new MentorDataStore();
        }
        return instance;
    }

    private MentorDataStore(){
        mentorNamesList.addAll(Mentors.defaultMentorNameList());
        mentorsList.addAll(Mentors.defaultMentorsList());
    }
}
