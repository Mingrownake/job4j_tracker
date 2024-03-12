package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public class Truck extends GroundTransport {
    private int size;
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public Truck(int size) {
        int id = atomicInteger.getAndIncrement();
        this.size = size;
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
