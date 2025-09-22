package com.example.module_3.decorator;

public class DecoratorExample {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " = " + coffee.getCost() + " руб.");

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " = " + coffee.getCost() + " руб.");

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " = " + coffee.getCost() + " руб.");

        coffee = new WhippedCreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " = " + coffee.getCost() + " руб.");
    }
}
