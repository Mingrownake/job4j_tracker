package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static String first = "Gav";

    public static String second = "Mooo";

    public static void main(String[] args) {
        String name = echo(
                () -> {
                    second = "Meow";
                    return first + second;
                }
        );
        System.out.println(name);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}