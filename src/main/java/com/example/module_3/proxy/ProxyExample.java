package com.example.module_3.proxy;

public class ProxyExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        image1.display();
        image1.display();
        image2.display();
    }
}
