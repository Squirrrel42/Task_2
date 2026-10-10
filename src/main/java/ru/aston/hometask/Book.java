package ru.aston.hometask;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Book {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("author")
    private final String author;
    @JsonProperty("numPages")
    private final int numPages;
    @JsonProperty("year")
    private final int year;

    public Book() {
        name = "unknown";
        author = "unknown";
        numPages = 1;
        year = 2000;
    }

    public Book(String name, String author, int numPages, int year) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.author = Objects.requireNonNull(author, "author must not be null");
        this.numPages = numPages;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getYear() {
        return year;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numPages == book.numPages && year == book.year && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, numPages, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", numPages=" + numPages +
                ", year=" + year +
                '}';
    }
}
