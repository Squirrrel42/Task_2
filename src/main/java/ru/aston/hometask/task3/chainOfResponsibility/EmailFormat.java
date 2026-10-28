package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;

public class EmailFormat extends BaseHandler {


    public EmailFormat(Map<String, String> clients, AuthenticationState authenticationState) {
        super(clients, authenticationState);
    }

    @Override
    public void handle(String email, String password) {
        String[] parts = email.split("@");

        if (parts.length != 2 || parts[0].isEmpty() || parts[parts.length - 1].isEmpty()) {
            System.out.println("invalid email format.");
            return;
        }

        String[] firstHalf = parts[0].split("\\.");
        String[] secondHalf = parts[1].split(("\\."));

        if (firstHalf[0].isEmpty() ||
                firstHalf[firstHalf.length - 1].isEmpty() ||
                secondHalf.length < 2 ||
                secondHalf[0].isEmpty() ||
                secondHalf[secondHalf.length - 1].isEmpty()) {
            System.out.println("invalid email format.");
            return;
        }

        super.handle(email, password);
    }
}
