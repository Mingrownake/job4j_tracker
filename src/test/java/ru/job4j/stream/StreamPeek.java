package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamPeek {
    public static void main(String[] args) {
        Stream<Integer> numStream = Stream.of(43, 65, 1, 98, 63);
        List<Integer> nList = numStream.map(n -> n * 10)
                .peek(n -> System.out.println("Mapped: " + n))
                .collect(Collectors.toList());
        System.out.println(nList);
    }
}
