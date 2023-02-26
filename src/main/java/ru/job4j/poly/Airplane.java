package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по воздуху.");
    }

    @Override
    public void maxSpeed() {
        System.out.println(getClass().getSimpleName() + " разгоняется до 400 км/ч.");
    }

    @Override
    public void madeOf() {
        System.out.println(getClass().getSimpleName() + " сделан из стали.");
    }
}
