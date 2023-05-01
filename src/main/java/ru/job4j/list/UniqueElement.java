package ru.job4j.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        boolean res = false;
        int indexFirst  = list.indexOf(str);
        int indexLast = list.lastIndexOf(str);
        if (indexFirst == indexLast && list.contains(str)) {
            res = true;
        }
        if (indexFirst != indexLast || !list.contains(str)) {
            return res;
        }
        return res;
    }
}