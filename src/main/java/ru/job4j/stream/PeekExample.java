package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Misha"),
                new StringBuilder("Ivan"),
                new StringBuilder("Elena")
        );
        List<StringBuilder> editedNames = names
                .stream()
                .peek((el) -> el.append(" is a Job4J student"))
                .sorted()
                .toList();
        System.out.println(editedNames);
    }
}
