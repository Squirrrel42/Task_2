package ru.aston.hometask;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Main.class.getResourceAsStream("/students.json");
        ObjectMapper objectMapper = new ObjectMapper();

        List<Student> students = objectMapper.readValue(inputStream, new TypeReference<List<Student>>() {});
        Stream<Student> stream = students.stream();
        stream
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