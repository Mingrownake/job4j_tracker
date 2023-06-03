package ru.job4j.function;

import java.util.function.Function;

public class FunctionTry {
    public static void main(String[] args) {
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Third symbol in the string is: " + func.apply("First"));
        System.out.println("Third symbol in the string is: " + func.apply("Second"));
    }
}
