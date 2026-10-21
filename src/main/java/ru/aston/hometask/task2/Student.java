package ru.aston.hometask.task2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Student {
    @JsonProperty("firstName")
    private final String firstName;
    @JsonProperty("lastName")
    private final String lastName;
    @JsonProperty("books")
    private final List<Book> books;

    @JsonCreator
    public Student(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("books") List<Book> books) {
        this.firstName = Objects.requireNonNull(firstName, "first name must not be null");
        this.lastName = Objects.requireNonNull(lastName, "last name cannot be null");
        Objects.requireNonNull(books, "books must not be null");
        if (books.size() < 5) throw new IllegalArgumentException("number of books must not be less than 5");
        this.books = List.copyOf(books);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(books, student.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, books);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
