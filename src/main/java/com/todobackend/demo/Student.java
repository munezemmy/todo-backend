package com.todobackend.demo;

public class Student {
    String fName;


    public Student(String fName) {
        this.fName = fName;

    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fName='" + fName + '\'' +
                '}';
    }
}
