package ru.job4j.collection;

import java.util.HashMap;

public class UsageMapTwo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ppechkin@prostokvashino.ru", "User user");
        map.put("ppechkin@prostokvashino.ru", "Pochtalyon Pechkin");
        map.put("dfedor@prostokvashino.ru", "Dyadya Vasya");
        map.put("dfedor@prostokvashino.ru", "Dyadya Fedor");
        map.put("kmatroskin@prostokvashino.ru", "Kot Kot");
        map.put("kmatroskin@prostokvashino.ru", "Kot Matroskin");
        map.put("psharik@prostokvashino.ru", "Dog dog");
        map.put("psharik@prostokvashino.ru", "Pios Sharik");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
