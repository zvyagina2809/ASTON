package com.example.module_1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
@Getter
public class Student {
    private String name;
    private int group;
    public List<Book> books;

    public Student(String name, int group, List<Book> books){
        this.name = name;
        this.group = group;
        this.books = books;
    }

    public String getName(){
        return name;
    }

    public int getGroup(){
        return group;
    }
    public List<Book> getBooks(){
        return books;
    }

    public static List<Student> generateStudentList() {
//        Random random = new Random();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов И.И.", 1154, Book.generateRandomBook(5)));
        students.add(new Student("Петров П.П.", 1211, Book.generateRandomBook(5)));
        students.add(new Student("Сидоров А.А.", 1745, Book.generateRandomBook(6)));
        students.add(new Student("Кабанов Р.Н.", 1302, Book.generateRandomBook(7)));
        students.add(new Student("Астапов П.В.", 1632, Book.generateRandomBook(5)));
        return students;
    }

    @Override
    public String toString() {
        return "Студент {ФИО=" + name + ", группа=" + group + ", список книг=" + books + "}";
    }
}
