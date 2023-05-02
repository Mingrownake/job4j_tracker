package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        Set<Character> result = new HashSet<>();
        for (char ch : s.toCharArray()) {
            result.add(ch);
        }
        return s.length() == result.size();
    }
}