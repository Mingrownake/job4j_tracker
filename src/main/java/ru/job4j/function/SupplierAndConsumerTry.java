package ru.job4j.function;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierAndConsumerTry {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String for Supplier Interface";
        Consumer<String> consumer = System.out::println;
        consumer.accept(sup.get());
    }
}
