package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class KetSetWithMapEntry {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(
                Map.of(
                        1, "root@root",
                        2, "local@local",
                        3, "host@host"
                )
        );
        /* map.forEach((key, value) -> System.out.println(key + " - " + value)); */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
