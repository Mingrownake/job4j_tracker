package ru.job4j.lambda;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> containsA = t -> t.contains("A");
        Predicate<String> containsB = t -> t.contains("B");
        System.out.println(containsA.or(containsB).test("CD"));
    }
}
