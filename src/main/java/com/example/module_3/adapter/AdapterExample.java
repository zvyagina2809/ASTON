package com.example.module_3.adapter;

public class AdapterExample {
    public static void main(String[] args) {
        // Работа с современным принтером
        ModernPrinter newPrinter = new NewAgePrinter();
        newPrinter.print("Документ 1");
        newPrinter.printColor("Цветной документ");

        // Работа со старым принтером через адаптер
        LegacyPrinter oldPrinter = new LegacyPrinter();
        ModernPrinter adaptedPrinter = new PrinterAdapter(oldPrinter);

        adaptedPrinter.print("Документ 2");
        adaptedPrinter.printColor("Цветной документ 2");
    }
}
