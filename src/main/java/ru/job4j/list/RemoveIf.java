package ru.job4j.list;

import java.util.List;
import java.util.function.Predicate;

public class RemoveIf {
    public static List<String> sortList(List<String> list) {
        Predicate<String> p;
        p = (value) -> value.length() < 5;
        list.removeIf(p);
        return list;
    }
}