package ru.job4j.function;

import javax.crypto.spec.PSource;
import java.util.function.BiPredicate;

public class BiPredicateTry {
    public static void main(String[] args) {
        BiPredicate<String, Integer> cond = (s, i) -> s.contains(i.toString());
        System.out.println("String contains substring: " + cond.test("Name123", 123));
        System.out.println("String contains substring: " + cond.test("Name", 456));
    }

}
