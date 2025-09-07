package com.example.module_1;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
@Getter
public class Book {
    private String name;
    private String author;
    private int year;
    private int pages;

    public Book(String name, String author, int year, int pages){
        this.name = name;
        this.author = author;
        this.year = year;
        this.pages = pages;
//        return this;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Книга {название='" + name + "', автор=" + author + ", год=" + year + ", количество страниц=" + pages + "}\n";
    }
    private static final Book[] BOOKS = {
            new Book("Высшая математика: теория групп и полей", "Иванов А.И.", 2018, 450),
            new Book("Теоретическая механика: уравнения Лагранжа", "Петров П.С.", 2015, 380),
            new Book("Квантовая электродинамика: продвинутый курс", "Сидоров В.К.", 2020, 520),
            new Book("Дифференциальная геометрия и тензорный анализ", "Кузнецов Д.М.", 2017, 410),
            new Book("Теория вероятностей и случайные процессы", "Николаев Г.П.", 2019, 490),

            // Учебники по гуманитарным наукам
            new Book("Древнегреческая палеография: анализ рукописей", "Орлова Е.В.", 2016, 320),
            new Book("Сравнительная лингвистика уральских языков", "Яковлев М.К.", 2014, 280),
            new Book("История византийской миниатюры X-XII веков", "Романова Т.И.", 2021, 360),
            new Book("Философия неоплатонизма: комментарии к Плотину", "Григорьев С.А.", 2018, 430),
            new Book("Медиевистика: источниковедение Средневековья", "Белова Л.Н.", 2017, 390),

            // Художественная литература
            new Book("Стеклянный пчельник", "Карл Чапек", 1922, 210),
            new Book("Жизнь насекомых", "Виктор Пелевин", 1993, 250),
            new Book("Автостопом по галактике", "Дуглас Адамс", 1979, 180),
            new Book("Пикник на обочине", "Братья Стругацкие", 1972, 230),
            new Book("Солярис", "Станислав Лем", 1961, 270),

            // Малоизвестная классика
            new Book("Облако-всадник", "Стефан Грабский", 1910, 190),
            new Book("Крейцерова соната", "Лев Толстой", 1889, 150),
            new Book("Рассказы о пилоте Пирксе", "Станислав Лем", 1968, 220),
            new Book("Голем", "Густав Майринк", 1915, 240),
            new Book("Мелкий бес", "Фёдор Сологуб", 1905, 310),

            // Современная непопулярная проза
            new Book("Электричество", "Виктор Пелевин", 2021, 290),
            new Book("Лавр", "Евгений Водолазкин", 2012, 350),
            new Book("Хроники заводной птицы", "Харуки Мураками", 1994, 610),
            new Book("Бесконечная шутка", "Дэвид Фостер Уоллес", 1996, 1079),
            new Book("Дом листьев", "Марк Данилевский", 2000, 709)
    };

    public static List<Book> generateRandomBook(int size) {
        Random random = new Random();
        List<Book> books = new ArrayList<>();
        for (int i=0; i < size; i++){
            books.add(BOOKS[random.nextInt(BOOKS.length)]);
        }
        return books;
    }
}
