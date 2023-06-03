package ru.job4j.function;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class SupplierAndBiConsumerTry {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New supplier's String ";
        BiConsumer<String, Integer> consumer = (s, s1) -> System.out.println(s + s1);
        consumer.accept(sup.get(), 123);
    }
}
