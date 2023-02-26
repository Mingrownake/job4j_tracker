package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }

    @Override
    public void maxSpeed() {
        System.out.println(getClass().getSimpleName() + " разгоняется до 250 км/ч.");
    }

    @Override
    public void madeOf() {
        System.out.println(getClass().getSimpleName() + " сделан из всякого.");
    }
}
