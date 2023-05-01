package ru.job4j.set;

import java.util.Set;

public class Firewall {
    public static String checkName(String str, Set<String> words) {
        String rsl = "Вы сделали правильный выбор!";
        String[] strSplit = str.split(" ");
        for (String word : strSplit) {
            if (words.contains(word)) {
                rsl = "Выберите другую статью...";
                break;
            }
        }
        return rsl;
    }
}