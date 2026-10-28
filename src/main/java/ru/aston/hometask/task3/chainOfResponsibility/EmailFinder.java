package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;

public class EmailFinder extends BaseHandler {

    public EmailFinder(Map<String, String> clients, AuthenticationState authenticationState) {
        super(clients, authenticationState);
    }

    @Override
    public void handle(String email, String password) {
        if(clients.containsKey(email)) {
            super.handle(email, password);
        }
        else {
            System.out.println("Account with your email did not found.");
        }
    }
}
