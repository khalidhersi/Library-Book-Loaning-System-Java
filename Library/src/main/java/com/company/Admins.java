package com.company;

public class Admins {
    private String name;
    private  String password;

    public Admins(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
