package ru.job4j.lambda;

import java.util.function.Predicate;

public class PredicateCheckEvenAndPositive {
    public  static boolean check(int num) {
        return echeck(n -> n > 0 && n % 2 == 0, num);
    }

    private static boolean echeck(Predicate<Integer> integerPredicate, int num) {
        return integerPredicate.test(num);
    }
}
