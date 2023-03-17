package ru.job4j.early;

public class PasswordValidator2 {
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
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter.");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter.");
        }
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecialSymbol = true;
            }
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

