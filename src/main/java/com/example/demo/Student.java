package com.example.demo;

import org.springframework.context.annotation.Bean;

public class Student {
    private String firstName;
    private String lastName;
    private Grade grade;


    Student(){}

    Student(String firstName, String lastName, Grade grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
    public String getLastName () {
        return lastName;
    }

    public String getFirstName () {
        return firstName;
    }

    public Grade getGrade () {
        return grade;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public void setGrade (Grade grade) {
        this.grade = grade;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
}
