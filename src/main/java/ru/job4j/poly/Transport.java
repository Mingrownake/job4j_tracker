package ru.job4j.poly;

public interface Transport {
    void ride();

    void passengers(int passenger);

    default void fillUpPrice(double litres) {
        System.out.println("Стоимость заправки: " + litres * 100 + " p.");
    }
}