package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;

public class PasswordFinder extends BaseHandler{

    public PasswordFinder(Map<String, String> clients, AuthenticationState authenticationState) {
        super(clients, authenticationState);
    }

    @Override
    public void handle(String email, String password) {
        if(clients.get(email).equals(password)) {
            System.out.println("Welcome!");
            authenticationState.state = true;
        }
        else {
            System.out.println("Wrong password.");
        }

    }
}
