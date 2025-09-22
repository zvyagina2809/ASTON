package com.example.module_3.builder;

class Product {
    private final String name;
    private final double price;
    private final String category;
    private final String description;

    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
        this.description = builder.description;
    }

    public static class Builder {
        private String name;
        private double price;
        private String category = "Отсутствует";
        private String description = "Нет описания";

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            if (name == null) {
                throw new IllegalStateException("Нужно указать имя");
            }
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Товар: %s, Цена: $%.2f, Категория: %s",
                name, price, category);
    }
}
