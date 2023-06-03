package ru.job4j.function;

import java.awt.*;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

public class BiFunctionTry {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> biFunc = (s, i) -> s.concat("*").concat(i.toString());
        System.out.println("The result of buFunc is: " + biFunc.apply("Name", 123));
        System.out.println("The result of buFunc is: " + biFunc.apply("String number", 45655));
    }
}
