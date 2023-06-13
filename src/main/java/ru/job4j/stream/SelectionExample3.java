package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String rsl = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("By default");
        System.out.println(rsl);

    }
}
