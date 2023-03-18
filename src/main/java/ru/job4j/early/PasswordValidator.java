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
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecialSymbol = true;
            }
            if (hasUpperCase && hasLowerCase
                    && hasDigit && hasSpecialSymbol) {
                break;
            }
        }
        if (!hasUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter.");
        }
        if (!hasLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter.");
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Password should contain at least one digit.");
        }
        if (!hasSpecialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol.");
        }
        return password;
    }
}

