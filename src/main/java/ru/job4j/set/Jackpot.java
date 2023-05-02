package ru.job4j.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        Set<String> combinationSet = new HashSet<>();
        combinationSet.addAll(Arrays.asList(combination));
        return combinationSet.size() == 1;
    }
}