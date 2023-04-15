package ru.job4j.search;

import java.util.LinkedList;

public class LinkedListTry {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add(0, "Petya");
        names.add(0, "Vasya");
        names.add(0, "Stepan");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
