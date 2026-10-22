package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;
import java.util.Scanner;

public class EmailFinder extends BaseHandler {

    public EmailFinder(Map<String, String> clients, AuthenticationState state) {
        super(clients, state);
    }

    @Override
    public void handle(String request) {
        if(clients.containsKey(request)) {
            super.handle(request);
        }
        else {
            System.out.println("Account with your email did not found.");
        }
    }
}
