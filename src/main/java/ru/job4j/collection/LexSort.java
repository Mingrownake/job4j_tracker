package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStr = left.replace(".", "").split(" ");
        String[] rightStr = right.replace(".", "").split(" ");
        return  Integer.compare(Integer.parseInt(leftStr[0]), Integer.parseInt(rightStr[0]));
    }
}
