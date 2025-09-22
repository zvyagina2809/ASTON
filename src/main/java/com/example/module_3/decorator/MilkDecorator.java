package com.example.module_3.decorator;

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", с молоком";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 30.0;
    }
}