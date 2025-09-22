package com.example.module_3.chainOfResponsibility;

abstract class Validator {
    protected Validator nextValidator;

    public Validator setNext(Validator nextValidator) {
        this.nextValidator = nextValidator;
        return nextValidator;
    }

    public abstract boolean validate(String data);

    protected boolean validateNext(String data) {
        if (nextValidator == null) {
            return true;
        }
        return nextValidator.validate(data);
    }
}
