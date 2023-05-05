package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfPresentExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "root");
        System.out.println(map.get(1));
        map.computeIfPresent(1, (key, value) -> value + "@root");
        System.out.println(map.get(1));
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
    }
}

