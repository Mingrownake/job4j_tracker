package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "first");
        System.out.println(map);
        map.computeIfAbsent(2, key -> "second" + "_" + key);
        System.out.println(map.get(2));
        System.out.println(map);
        map.computeIfAbsent(1, key -> "first" + "_" + key);
        System.out.println(map.get(1));
        System.out.println(map);
    }
}
