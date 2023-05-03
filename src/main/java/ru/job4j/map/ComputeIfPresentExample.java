package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfPresentExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "root"); /* добавляем значение пару ключ-значение в отображение */
        System.out.println(map.get(1)); /* в консоль будет выведена строка root */
        map.computeIfPresent(1, (key, value) -> value + "@root"); // изменяем значение которое ЕСТЬ в отображении
        System.out.println(map.get(1)); // в консоль будет выведена строка root@root
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
    }
}

