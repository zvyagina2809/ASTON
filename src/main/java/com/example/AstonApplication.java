package com.example;

import com.example.module_1.Book;
import com.example.module_1.MyHashSet;
import com.example.module_1.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class AstonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AstonApplication.class, args);
        List<Student> students = Student.generateStudentList();
        System.out.println(students.stream().collect(Collectors.toList()));
//        System.out.println(students.stream()
//                .flatMap(student -> student.getBooks().stream())
//                .collect(Collectors.toList()));
        System.out.println(students.stream()
                .flatMap(student -> student.getBooks().stream())
                .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .filter(s -> s.getYear() > 2000)
                .distinct()
                .limit(3)
                .collect(Collectors.toList()));
        System.out.println(students.stream()
                .flatMap(student -> student.getBooks().stream())
                .map(Book::getYear)
                .distinct()
                .sorted()
                .collect(Collectors.toList()));
        students.stream()
                .flatMap(student -> student.getBooks().stream())
                .filter(book -> "Иванов А.И.".equals(book.getAuthor()))
                .findAny()
                .ifPresentOrElse(
                        book -> System.out.println(book.toString()),
                        () -> System.out.println("Книга не найдена")
                );

//        try {
//            System.out.println(students.stream()
//                            .flatMap(student -> student.getBooks().stream())
//                            .filter(book -> "Иванов А.И.".equals(book.getAuthor()))
//                            .findAny()
//                            .orElseThrow(() -> new RuntimeException("Книга не найдена")));
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
    }

}
