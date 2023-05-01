package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String str) {
        Set<Character> stringSet = new HashSet<>();
        str = str.toLowerCase().replaceAll(" ", "");
        for (char ch : str.toCharArray()) {
            stringSet.add(ch);
        }
        return stringSet.size() == 26;

    }
}