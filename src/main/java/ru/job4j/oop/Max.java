package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int left, int last, int right) {
        return max(left, max(last, right));
    }

    public static int max(int first, int left, int right, int last) {
        return max(first, max(left, max(last, right)));
    }

    public static int max(int first, int second, int right, int left, int last) {
        return max(second, max(first, max(left, max(last, right))));
    }
}
