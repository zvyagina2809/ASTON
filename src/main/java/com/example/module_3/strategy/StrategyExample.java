package com.example.module_3.strategy;

public class StrategyExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(1000);

        cart.setPaymentStrategy(new PayPalPayment("user@gmail.com"));
        cart.checkout(2000);
    }
}
