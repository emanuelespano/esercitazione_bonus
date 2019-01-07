package com.example.emanuelespano.esercitazione_bonus;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object usr) {
        return this.username.equals((((User) usr).username)) && this.password.equals((((User) usr).password));
    }

    @Override
    public String toString() {
        return username +" " +password;
    }

}