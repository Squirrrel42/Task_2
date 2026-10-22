package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;

class BaseHandler implements Handler{

    private Handler nextHandler;
    protected Map<String, String> clients;
    protected AuthenticationState state;

    public BaseHandler(Map<String, String> clients, AuthenticationState state) {
        this.clients = clients;
        this.state = state;
    }

    @Override
    public void setNext(Handler h) {
        nextHandler = h;
    }

    @Override
    public void handle(String request) {
        if(nextHandler != null) {
            nextHandler.handle(request);
        }
    }
}
