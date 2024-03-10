package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public class Car extends GroundTransport {
    private int size = 1;

    private AtomicInteger number;

    public Car(int size, AtomicInteger number) {
        this.size = size;
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public AtomicInteger getNumber() {
        return number;
    }

    public void setNumber(AtomicInteger number) {
        this.number = number;
    }
}
