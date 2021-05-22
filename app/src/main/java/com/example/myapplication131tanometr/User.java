package com.example.myapplication131tanometr;

import android.widget.EditText;

import java.util.ArrayList;

public class User {
    String surname;
    String name;
    String lastname;

    public User(String surname, String name, String lastname){
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;

    }
    static ArrayList<User> user = new ArrayList<User>();

}
