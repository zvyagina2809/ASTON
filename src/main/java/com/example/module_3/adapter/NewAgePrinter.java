package com.example.module_3.adapter;

class NewAgePrinter implements ModernPrinter {
    @Override
    public void print(String content) {
        System.out.println("Современный принтер: " + content);
    }

    @Override
    public void printColor(String content) {
        System.out.println("Современный принтер (цвет): " + content);
    }
}
