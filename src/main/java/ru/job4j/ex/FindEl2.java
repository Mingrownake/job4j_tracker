package ru.job4j.ex;

import java.util.Objects;

public class FindEl2 {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (Objects.equals(value[index], key)) {
                rsl = index;
                break;
            }
        } if (rsl == -1) {
            throw new ElementNotFoundException("The array should contain the element");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"a"}, "q");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}