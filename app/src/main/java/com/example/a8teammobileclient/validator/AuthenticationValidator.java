package com.example.a8teammobileclient.validator;

public class AuthenticationValidator {
    private static final Integer MIN_LOGIN_PASSWORD_SIZE = 3;
    private static final String LOGIN_PASSWORD_PATTERN = "^\\w{3,}$";

    private static final Integer MIN_NAME_SIZE = 3;
    private static final String NAME_PATTERN = "^[А-ЯІЇЄҐ][а-яіїєґи]{2,} [А-ЯІЇЄҐ][а-яіїєґи]{2,}$";

    public static void validateLoginOrPassword(String word){
        if(word.length() < MIN_LOGIN_PASSWORD_SIZE){
            throw new RuntimeException("Поле має містити більше ніж 2 символа");
        }
        if(!word.matches(LOGIN_PASSWORD_PATTERN)){
            throw new RuntimeException("Поле може містити лише літери, цифри та _");
        }
    }

    public static void validateName(String name){
        if(name.length() < MIN_NAME_SIZE){
            throw new RuntimeException("Поле має містити більше ніж 2 символа");
        }
        if(!name.matches(NAME_PATTERN)){
            throw new RuntimeException("Поле має відповідати шаблону: \"^[А-ЯІЇЄҐ][а-яіїєґи]{2,} [А-ЯІЇЄҐ][а-яіїєґи]{2,}$\"");
        }
    }

    public static void confirmPasswords(String first, String second){
        if(!first.equals(second)){
            throw new RuntimeException("Паролі не співпадають");
        }
    }
}
