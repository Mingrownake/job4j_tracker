package ru.job4j.ex;

public class JdbcConfig {
    public static void load(String url) throws UserInputException {
        if (url == null) {
            throw new UserInputException("Url cannot be null");
        }
        /* load jbdbc*/
    }

    public static void main(String[] args) throws UserInputException {
        load("jdbc://localhost:800");
    }
}
