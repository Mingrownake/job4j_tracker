package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(258548, "Murka");
        map1.put(255548, "Sharik");
        map1.put(338548, "Busya");
        map1.put(257778, "Bobik");
        map1.put(null, "Polkan");
        map1.put(573999, null);
        map1.putIfAbsent(255548, "Tom"); /*Не перезатрёт Мурку*/
        System.out.println(map1);
        System.out.println(map1.get(338548));
        System.out.println(map1.get(674848)); /*null*/
        map1.remove(257778);
        System.out.println(map1.containsKey(257778));
        System.out.println(map1.containsValue("Murka"));
        System.out.println(map1.keySet());
        System.out.println(map1.values());
    }
}