package ru.job4j.list;

import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        if (list.indexOf(el) != -1  && list.lastIndexOf(el) != -1
                && list.indexOf(el) != list.lastIndexOf(el)) {
            list = list.subList(list.indexOf(el), list.lastIndexOf(el));
        } else {
            list.clear();
        }
        return list;
    }
}