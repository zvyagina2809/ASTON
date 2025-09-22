package com.example.module_3.strategy;

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплата " + amount + " руб. картой " + cardNumber);
    }
}
