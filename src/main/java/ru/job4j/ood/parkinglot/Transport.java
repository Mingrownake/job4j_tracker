package ru.job4j.ood.parkinglot;

import java.util.concurrent.atomic.AtomicInteger;

public interface Transport {

    int getSize();

    AtomicInteger getNumber();

    void setNumber(AtomicInteger number);
}
