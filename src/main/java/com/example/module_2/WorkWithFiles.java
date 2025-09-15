package com.example.module_2;


import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class WorkWithFiles {

    public static void main(String[] args) throws FileOperationException {
        String s = "Hello";
        String filePath = "C:\\Users\\zvyag\\IdeaProjects\\ASTON\\src\\main\\resources\\input.txt";
//        String filePath1 = "C:\\Users\\zvyag\\IdeaProjects\\ASTON\\src\\main\\resources\\input1.txt";
        Path of = Path.of(filePath);
        try {
            Files.write(of, s.getBytes(), StandardOpenOption.WRITE);
            System.out.println("Успешная запись");
        } catch (IOException e) {
            throw new FileOperationException("Не удалось прочитать файл: " + filePath, e);
        }
        try {
            byte[] bytes = Files.readAllBytes(of);
            System.out.println("Прочитано: " + new String(bytes));
        } catch (IOException e) {
            throw new FileOperationException("Не удалось прочитать файл: " + filePath, e);
        }
    }
}
//C:\Users\zvyag\IdeaProjects\ASTON\src\main\resources\input.txt
