package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public class Truck extends GroundTransport {
    private int size;
    private int id;

    public Truck(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
