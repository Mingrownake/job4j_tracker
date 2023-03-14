package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password's length should be [8, 32].");
        }
        String[] forbiddenSubstrings = {"qwerty", "12345", "password", "admin", "user"};
        for (String substring : forbiddenSubstrings) {
            if (password.toLowerCase().contains(substring)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user.");
            }
        }
        boolean hasUpperCase = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
                break;
            }
        }
        if (!hasUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter.");
        }
        boolean hasLowerCase = false;
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
                break;
            }
        }
        if (!hasLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter.");
        }
        boolean hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Password should contain at least one digit.");
        }
        boolean hasSymbol = false;
        for (char ch : password.toCharArray()) {
            if (!Character.isAlphabetic(ch) && !Character.isDigit(ch)) {
                hasSymbol = true;
                break;
            }
        }
        if (!hasSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol.");
        }
        return password;
    }
}

