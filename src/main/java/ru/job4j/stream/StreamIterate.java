package ru.job4j.stream;

import java.util.stream.Stream;

public class StreamIterate {
    public static void showArray(Integer[] data) {
        Stream.iterate(0, i -> i < data.length - 1, i -> i + 2)
                .forEach(i -> System.out.println(data[i]));
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 8, 5, 4};
        StreamIterate.showArray(arr);
    }
}