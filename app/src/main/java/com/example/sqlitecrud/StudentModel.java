package com.example.sqlitecrud;

public class StudentModel {
    String name, course, email;
    int age,id;

    public StudentModel(int id,String name, String course, String email, int age) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
