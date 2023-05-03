package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "first"); // добавляем пару ключ-значение
        System.out.println(map);
        map.computeIfAbsent(2, key -> "second" + "_" + key); // вычисляем значение для ключа, которого нет в отображении
        System.out.println(map.get(2)); // будет выведено second_2
        System.out.println(map);
        map.computeIfAbsent(1, key -> "first" + "_" + key); // вычисляем значение для ключа, которого нет в отображении
        System.out.println(map.get(1)); // будет выведено first, т.е. значение не изменилось
        System.out.println(map);
    }
}
