package ru.job4j.poly;

public interface Vehicle {
    void move();

    void maxSpeed();

    default void madeOf() {
        System.out.println(getClass().getSimpleName() + " сделан из железяк.");
    }
}
