package ru.job4j.list;

import java.util.List;

public class SplitterList {
    public static List<String> split(List<String> general, List<String> minor, List<String> mustbe) {
        general.retainAll(minor);
        general.removeAll(mustbe);
        return general;
    }
}