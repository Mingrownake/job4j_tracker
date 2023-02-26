package ru.job4j.poly;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по трассе.");
    }

    @Override
    public void maxSpeed() {
        System.out.println(getClass().getSimpleName() + " разгоняется до 80 км/ч.");
    }

    @Override
    public void madeOf() {
        Vehicle.super.madeOf();
    }
}
