package ru.job4j.function;

import java.util.function.Predicate;

public class PredicateTry {
    public static void main(String[] args) {
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("String is empty: " + pred.test(""));
        System.out.println("String is empty: " + pred.test("test"));
    }
}
