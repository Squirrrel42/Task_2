package ru.aston.hometask.task2;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        final ObjectMapper objectMapper = new ObjectMapper();

        final List<Student> students;
        try {
            students = objectMapper.readValue(new File("/students.json"), new TypeReference<List<Student>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getNumPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No books published after year 2000 found"));
    }
}