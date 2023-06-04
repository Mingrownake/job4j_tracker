package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside2 {
    public static void main(String[] args) {
        String ayyyy = "ayyyyywww";
        String name = returnString(
                () -> {
                    return ayyyy + ayyyy;
                }
        );
        System.out.println(name);
    }

    private static String returnString(Supplier<String> supplierO) {
        /**
         * вызов метода get у экз Supplier
         * зарисывается  в переменную String sound
         */
        String sound = supplierO.get();
        return sound + " " + sound + " " + sound;
    }
}