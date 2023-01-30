package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активный " + active);
        System.out.println("Статус " + status);
        System.out.println("Сообщение " + message);
    }

    public static void main(String[] args) {
        Error minorError = new Error();
        Error notFoundError = new Error(false, 404, "Not Found Error");
        Error internalError = new Error(true, 500, "Internal Error");
        Error redirectError = new Error(false, 307, "Temporary Redirect");
        minorError.printInfo();
        notFoundError.printInfo();
        internalError.printInfo();
        redirectError.printInfo();
    }
}
