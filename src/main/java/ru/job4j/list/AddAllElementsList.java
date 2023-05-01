package ru.job4j.list;

import java.util.List;

public class AddAllElementsList {
    public static int containsElement(List<String> left, List<String> right, String str) {
        int rsl = -1;
        if (left.contains(str) && right.contains(str)) {
            left.remove(str);
            left.addAll(right);
            rsl = left.indexOf(str);
        }
        left.addAll(right);
        rsl = left.indexOf(str);
        return rsl;
    }
}