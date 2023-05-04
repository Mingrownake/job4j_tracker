package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class MapMergeExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Bill"); // добавляем пару ключ-значение
        map.merge(1, "Clinton", (oldV, newV) -> oldV + " " + newV); // заменяем значением новой строки, пары, которая есть в отображении
        System.out.println(map.get(1)); // будет выведено Bill Clinton
        System.out.println(map);
        map.merge(2, "Trump", (oldV, newV) -> oldV + " " + newV); // если такого ключа нет в отображении - пара будет просто создана
        System.out.println(map.get(2)); // будет выведено Trump
        System.out.println(map);
    }
}
