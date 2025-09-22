package com.example.module_3.decorator;

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", с сахаром";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 10.0;
    }
}