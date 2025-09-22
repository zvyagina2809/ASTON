package com.example.module_3.adapter;

class PrinterAdapter implements ModernPrinter {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String content) {
        legacyPrinter.printDocument(content);
    }

    @Override
    public void printColor(String content) {
        System.out.println("Цветная печать не поддерживается. Печатаем черно-белое:");
        legacyPrinter.printDocument(content);
    }
}
