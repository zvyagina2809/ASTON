package com.example.module_3.chainOfResponsibility;

class LengthValidator extends Validator {
    private int minLength;
    private int maxLength;

    public LengthValidator(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean validate(String data) {
        if (data.length() < minLength) {
            System.out.println("Длина должна быть не менее " + minLength + " символов");
            return false;
        }
        if (data.length() > maxLength) {
            System.out.println("Длина должна быть не более " + maxLength + " символов");
            return false;
        }
        return validateNext(data);
    }
}