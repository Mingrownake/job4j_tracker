package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public class Truck extends GroundTransport {
    private int size;

    private AtomicInteger number;

    public Truck(int size, AtomicInteger number) {
        this.size = size;
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
