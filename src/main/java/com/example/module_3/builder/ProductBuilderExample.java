package com.example.module_3.builder;

public class ProductBuilderExample {
    public static void main(String[] args) {
        Product laptop = new Product.Builder()
                .name("Ноутбук")
                .price(999.99)
                .category("Электроника")
                .description("Игровой ноутбук")
                .build();

        Product book = new Product.Builder()
                .name("Книга по Java")
                .price(29.99)
                .build();

        System.out.println(laptop);
        System.out.println(book);
    }
}
