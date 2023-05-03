package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        str = str.toLowerCase().replaceAll(" ", "");
        TreeMap<Character, Integer> map = new TreeMap<>();
        //char rsl = ' ';
        for (char ch : str.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.putIfAbsent(ch, 1);
            }
            int num = map.get(ch);
            num++;
            int finalNum = num;
            map.computeIfPresent(ch, (key, value) -> finalNum);
        }
        int max = 0;
        for (Integer i : map.values()) {
            if (i > max) {
                max = i;
            }
        }
        char res = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }
}