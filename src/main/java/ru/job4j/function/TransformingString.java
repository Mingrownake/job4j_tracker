package ru.job4j.function;

import java.util.function.Function;

public class TransformingString {
    public String transform(Function<String, String> fun, String s) {
        return fun.apply(s);
    }

    public static void main(String[] args) {
        TransformingString transformingString = new TransformingString();
        System.out.println(
                "String after transformation toUpperCase: " + transformingString.transform(
                        str -> str.toUpperCase(), "KittyCatKK"
                )
        );
        System.out.println(
                "String after transformation DeleteWhiteSpaces: " + transformingString.transform(
                        str -> str.replace(" ", ""), " T t t tt "
                )
        );
        System.out.println(
                "String after transformation concat: " + transformingString.transform(
                        str -> str.concat("str"), "another str +"
                )
        );
    }
}
