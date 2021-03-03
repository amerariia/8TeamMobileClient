package com.example.a8teammobileclient.validator;

public class AuthenticationValidator {
    private static final Integer MIN_LOGIN_PASSWORD_SIZE = 3;
    private static final String LOGIN_PASSWORD_PATTERN = "^\\w{3,}$";

    private static final Integer MIN_NAME_SIZE = 3;
    private static final String NAME_PATTERN = "^[А-ЯІЇЄҐ][а-яіїєґи]{2,} [А-ЯІЇЄҐ][а-яіїєґи]{2,}$";

    public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static void validateLogin(String word){
        if(word.length() < MIN_LOGIN_PASSWORD_SIZE){
            throw new RuntimeException("Логін має містити більше ніж 2 символа");
        }
        if(!word.matches(LOGIN_PASSWORD_PATTERN)){
            throw new RuntimeException("Логін може містити лише літери, цифри та _");
        }
    }

    public static void validatePassword(String word){
        if(word.length() < MIN_LOGIN_PASSWORD_SIZE){
            throw new RuntimeException("Пароль має містити більше ніж 2 символа");
        }
        if(!word.matches(LOGIN_PASSWORD_PATTERN)){
            throw new RuntimeException("Пароль може містити лише літери, цифри та _");
        }
    }

    public static void validateEmail(String email){
        if(!email.matches(EMAIL_PATTERN)){
            throw new RuntimeException("Невірний формат пошти");
        }
    }

    public static void validateName(String name){
        if(name.length() < MIN_NAME_SIZE){
            throw new RuntimeException("Прізвище та ім'я мають містити більше символів");
        }
        if(!name.matches(NAME_PATTERN)){
            throw new RuntimeException("Прізвище та ім'я мають складатися з двох слів, розділених пробілом");
        }
    }

    public static void confirmPasswords(String first, String second){
        if(!first.equals(second)){
            throw new RuntimeException("Паролі не співпадають");
        }
    }
}
