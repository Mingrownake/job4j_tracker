package ru.job4j.ood.parkinglot;

import java.util.Vector;

public class GroundParking implements Parking {

    private Transport[] parkingLots;

    private int freeLotIndex; /*Свободное место, с кторого начинать парковать */

    public GroundParking(Transport[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public void parkTransport(Transport transport) {
        int i;
        for (i = freeLotIndex; i < transport.getSize(); i++) {
            parkingLots[i] = transport;
        }
        freeLotIndex += i;
    }

    @Override
    public int getFreeLots() {
        return parkingLots.length
                - freeLotIndex;
    }

    @Override
    public int getOccupiedLots() {
        return freeLotIndex;
    }
}
