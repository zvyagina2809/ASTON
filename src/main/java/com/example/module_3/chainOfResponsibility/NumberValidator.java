package com.example.module_3.chainOfResponsibility;

class NumberValidator extends Validator {
    @Override
    public boolean validate(String data) {
        try {
            Integer.parseInt(data);
            System.out.println("Это число");
            return validateNext(data);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
