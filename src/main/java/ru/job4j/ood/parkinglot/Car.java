package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public class Car extends GroundTransport {
    private final int size = 1;

    private AtomicInteger number;

    public Car(int size, AtomicInteger number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public AtomicInteger getNumber() {
        return number;
    }

    @Override
    public void setNumber(AtomicInteger number) {
        this.number = number;
    }
}
