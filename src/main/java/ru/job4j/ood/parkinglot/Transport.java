package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public interface Transport {

    int getId();

    int getSize();

    void setId(int id);
}
