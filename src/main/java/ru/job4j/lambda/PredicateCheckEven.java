package ru.job4j.lambda;

import java.util.function.Predicate;

public class PredicateCheckEven {
    public static boolean check(int num) {
        return (echeck(n -> n % 2 == 0, num));
    }
    
    private static boolean echeck(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }
}
