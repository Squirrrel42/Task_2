package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;

class BaseHandler implements Handler{

    private Handler nextHandler;
    protected Map<String, String> clients;
    protected AuthenticationState authenticationState;

    public BaseHandler(Map<String, String> clients, AuthenticationState authenticationState) {
        this.clients = clients;
        this.authenticationState = authenticationState;
    }

    @Override
    public void setNext(Handler h) {
        nextHandler = h;
    }

    @Override
    public void handle(String email, String password) {
        if(nextHandler != null) {
            nextHandler.handle(email, password);
        }
    }
}
