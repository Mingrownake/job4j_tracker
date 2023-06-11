package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ListToMap2 {
    public static void main(String[] args) {
        System.out.println(
                List.of(1, 2, 3, 4).stream().collect(
                        Collectors.toMap(
                                e -> e,
                                e -> e * e,
                                (existing, replacement) -> existing
                        )
                )
        );
    }
}
