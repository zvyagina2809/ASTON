package com.example.module_3.decorator;

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", со взбитыми сливками";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 50.0;
    }
}