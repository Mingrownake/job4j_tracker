package ru.job4j.collection;

public class Box {
    public static void main(String[] args) {
        int a = 1;
        Integer b; /*значение примитивного типа int присваивается типу Integer:; b = Integer.valueOf(a); */
        b = a;
        System.out.println("Integer b = " + b);
        int x = 2;
        num(x);
    }

    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void num(int x) {
        System.out.println("Значение типа int: " + x);
    }
}
