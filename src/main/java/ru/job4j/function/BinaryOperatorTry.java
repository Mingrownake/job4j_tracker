package ru.job4j.function;

import java.util.function.BinaryOperator;

public class BinaryOperatorTry {
    public static void main(String[] args) {
        BinaryOperator<StringBuilder> builder = (b1, b2) -> b1.append("+").append(b2);
        System.out.println(builder.apply(new StringBuilder("qwerty"), new StringBuilder("123")));
    }
}
