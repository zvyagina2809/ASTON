package com.example.module_3.chainOfResponsibility;

class NotEmptyValidator extends Validator {
    @Override
    public boolean validate(String data) {
        if (data == null || data.trim().isEmpty()) {
            System.out.println("Поле не может быть пустым");
            return false;
        }
        return validateNext(data);
    }
}
