package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class SupplierTry {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        Set<String> strings = sup.get();
        strings.forEach(System.out::println);
    }
}
