package ru.aston.hometask.task3.proxy;

public class Image {
    public final String fileName;
    public final int data;

    Image(String fileName) {
        this.fileName = fileName;
        this.data = fileName.hashCode();
    }

    public void show() {
        System.out.println("\nShowing image '" + fileName + "': " + data);
    }
}
