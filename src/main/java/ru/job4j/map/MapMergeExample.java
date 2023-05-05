package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class MapMergeExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Bill");
        map.merge(1, "Clinton", (oldV, newV) -> oldV + " " + newV);
        System.out.println(map.get(1));
        System.out.println(map);
        map.merge(2, "Trump", (oldV, newV) -> oldV + " " + newV);
        System.out.println(map.get(2));
        System.out.println(map);
    }
}
