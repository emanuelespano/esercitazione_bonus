package com.example.emanuelespano.esercitazione_bonus;

import java.util.ArrayList;

public class UserFactory {

    private static UserFactory instance;
    private ArrayList<User> users = new ArrayList<>();

    private UserFactory () {
        users.add(new User("Emanuele", "ema"));
        users.add(new User("Salvini", "ruspa"));
        users.add(new User("Dimaio", "cittadinanza"));
    }

    public static UserFactory getInstance () {
        if (instance == null)
            instance = new UserFactory();

        return instance;
    }

    public ArrayList<User> getUsers () {

        return users;

    }
}
