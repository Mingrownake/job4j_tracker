package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Some Code", 155);
        Book secondBook = new Book("Not Clean Code", 666);
        Book thirdBook = new Book("Java Code", 500);
        Book fourthBook = new Book("Clean Code", 1000);
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " has " + bk.getPagesNumber() + " pages.");
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " has " + bk.getPagesNumber() + " pages.");
        }
        for (Book bk : books) {
            if (bk.getName().equals("Clean Code")) {
                System.out.println(bk.getName());
            }
        }
    }
}