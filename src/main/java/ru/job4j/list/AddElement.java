package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class AddElement {
    public static boolean addNewElement(List<String> list, String str) {
        List<String> check = new ArrayList<>(list);
        check.add(list.toString());
        list.add(check.toString());
        return check.size() == list.size();
    }
}