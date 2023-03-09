package ru.job4j.ex;

public class JdbcConfigTryCatch {
    public static void load(String url) throws UserInputException {
        if (url == null) {
            throw new UserInputException("Url cannot be null");
        }
        /* load jbdbc */
    }

    public static void main(String[] args) {
        try {
            load(null);
        } catch (UserInputException e) {
            e.printStackTrace();
        }
    }
}


