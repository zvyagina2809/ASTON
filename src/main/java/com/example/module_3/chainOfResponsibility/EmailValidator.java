package com.example.module_3.chainOfResponsibility;

class EmailValidator extends Validator {
    @Override
    public boolean validate(String data) {
        if (!data.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Неверный формат email");
            return false;
        }
        return validateNext(data);
    }
}
