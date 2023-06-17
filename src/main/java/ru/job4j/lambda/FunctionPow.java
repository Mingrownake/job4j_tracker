package ru.job4j.lambda;

import java.util.function.Function;

public class FunctionPow {

    public static double calculate(double x) {
        return calculate(i -> i * i, x);
    }

    public static double calculate(Function<Double, Double> func, double x) {
        return func.apply(x);
    }
}