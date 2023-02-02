package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int left, int last, int right) {
        int max1 = left > last ? left : last;
        return max1 > right ? max1 : right;
    }

    public static int max(int first, int left, int right, int last) {
        int max1 = left > right ? left : right;
        int max2 = last > first ? last : first;
        return max1 > max2 ? max1 : max2;
    }
}
