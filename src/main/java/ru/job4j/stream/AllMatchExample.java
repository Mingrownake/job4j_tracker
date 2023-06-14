package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class AllMatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Трижды", "Три", "Триста", "Три тысячи");
        boolean rsl = strings
                .stream()
                .allMatch(e -> e.contains("р"));
        System.out.println(rsl);
    }
}