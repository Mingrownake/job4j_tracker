package ru.job4j.api;

import java.util.List;

public class DropWhile {
    public static void main(String[] args) {
        List.of(1, 2, 1, 4, 6, 5, 1, 0, 9).stream()
                .dropWhile(number -> number < 3)
                .map(number -> "Result is : " + number)
                .forEach(System.out::println);
    }
}