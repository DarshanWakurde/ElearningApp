package com.example.elearningapp;

public class Student {
    String email,name,pass;
    int id;
Long mobile;


    public Student() {
    }
    public Student(String email, String name, String pass, long mobile, int id) {
        this.email = email;
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
