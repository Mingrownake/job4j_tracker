package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Девять", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(rsl);
    }
}
