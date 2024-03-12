package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public class Car extends GroundTransport {
    private final int size = 1;

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public Car(int size) {
        int id = atomicInteger.getAndIncrement();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getId() {
        return atomicInteger.get();
    }

    @Override
    public void setId(int id) {

    }
}
