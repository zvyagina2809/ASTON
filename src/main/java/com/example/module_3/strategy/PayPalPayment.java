package com.example.module_3.strategy;

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплата " + amount + " руб. через PayPal " + email);
    }
}
