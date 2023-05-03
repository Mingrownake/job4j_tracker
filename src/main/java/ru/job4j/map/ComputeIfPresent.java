package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Map.Entry<Integer, String> entryName : name.entrySet()) {
            name.computeIfPresent(entryName.getKey(), (key, value) -> value + " " + surname.get(entryName.getKey()));
        }
        return name;
    }
}
