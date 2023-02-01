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
        Calculator calculator = new Calculator();
        int multiplyResult = calculator.multiply(i);
        int sumResult = Calculator.sum(i);
        int minusResult = Calculator.minus(i);
        Calculator newCalculator = new Calculator();
        int divideResult = newCalculator.divide(i);
        return multiplyResult + sumResult + minusResult + divideResult;
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
        int sumAllResult = anotherCalculator.sumAllOperation(10);
        System.out.println(sumAllResult);

    }
}