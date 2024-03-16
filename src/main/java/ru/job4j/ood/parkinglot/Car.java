package ru.job4j.ood.parkinglot;

public class Car extends GroundTransport {
    private int size;

    private int id;

    public Car(int id, int size) {
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
