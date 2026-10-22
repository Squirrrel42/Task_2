package ru.aston.hometask.task3.chainOfResponsibility;

public interface Handler {
    void setNext(Handler h);
    void handle(String request);
}
