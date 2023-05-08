package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftStr = left.toCharArray();
        char[] rightStr = right.toCharArray();

        int res = 0;
        boolean flag = false;
        if (leftStr.length < rightStr.length) {
            for (int i = 0; i < leftStr.length; i++) {
                if (leftStr[i] != rightStr[i]) {
                    res = Character.compare(leftStr[i], rightStr[i]);
                    flag = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < rightStr.length; i++) {
                if (leftStr[i] != rightStr[i]) {
                    res = Character.compare(leftStr[i], rightStr[i]);
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            res = Integer.compare(leftStr.length, rightStr.length);
        }
        return res;
    }
}