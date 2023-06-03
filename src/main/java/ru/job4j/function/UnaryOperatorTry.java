package ru.job4j.function;

import java.util.function.UnaryOperator;

public class UnaryOperatorTry {
    public static void main(String[] args) {
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("String after being reversed: " + builder.apply(new StringBuilder("Test")));
        System.out.println("String after being reversed: " + builder.apply(new StringBuilder("tseT")));

    }
}
