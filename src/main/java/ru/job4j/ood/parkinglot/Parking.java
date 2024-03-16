package ru.job4j.ood.parkinglot;

public interface Parking {

    int getFreeLots();  /* получить кол-во свободных мест */

    int getOccupiedLots(); /* получить кол-во занятных мест */

    int getFreeLotIndex();

    Transport[] getParkingLots();

    void setNewFreeLotIndex(int i);
}
