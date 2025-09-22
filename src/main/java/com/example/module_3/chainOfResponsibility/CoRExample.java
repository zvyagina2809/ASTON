package com.example.module_3.chainOfResponsibility;

public class CoRExample {
    public static void main(String[] args) {
        Validator emailValidator = new NotEmptyValidator();
        emailValidator.setNext(new LengthValidator(7, 50))
                .setNext(new EmailValidator());

        System.out.println("=== Валидация email ===");
        testValidator(emailValidator, "");
        testValidator(emailValidator, "ab");
        testValidator(emailValidator, "user@gmail.com");

        Validator ageValidator = new NotEmptyValidator();
        ageValidator.setNext(new NumberValidator())
                .setNext(new LengthValidator(1, 3));

        System.out.println("\n=== Валидация возраста ===");
        testValidator(ageValidator, "");
        testValidator(ageValidator, "abc");
        testValidator(ageValidator, "25");
    }

    private static void testValidator(Validator validator, String data) {
        System.out.println("\nПроверка: '" + data + "'");
        boolean isValid = validator.validate(data);
        System.out.println("Результат: " + (isValid ? "УСПЕХ" : "ОШИБКА"));
    }
}
