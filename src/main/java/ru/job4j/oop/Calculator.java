package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int i) {
        return Calculator.sum(i) + Calculator.minus(i) + multiply(i) + divide(i);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int multiplyResult = calculator.multiply(5);
        System.out.println(multiplyResult);
        int sumResult = Calculator.sum(10);
        System.out.println(sumResult);
        int minusResult = Calculator.minus(5);
        System.out.println(minusResult);
        Calculator newCalculator = new Calculator();
        int divideResult = newCalculator.divide(5);
        System.out.println(divideResult);
        Calculator anotherCalculator = new Calculator();
        int sumAllResult = anotherCalculator.sumAllOperation(0);
        System.out.println(sumAllResult);

    }
}