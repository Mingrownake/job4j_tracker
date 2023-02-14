package ru.job4j.concat;

import java.util.StringJoiner;
public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("abc").add("def").add("ghi");
        String joined = stringJoiner.toString();
        System.out.println(joined);
    }
}
