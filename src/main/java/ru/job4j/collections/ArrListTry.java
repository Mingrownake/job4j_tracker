package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrListTry {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Name");
        names.set(0, "Ivan");
        names.remove(0);
        for (int index = 0; index < names.size(); index++) {
            Object value = names.get(index);
            System.out.println();
        }

        for (Object value : names) {
            System.out.println(value);
        }
    }
}
