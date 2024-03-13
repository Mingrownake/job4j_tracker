package ru.job4j.ood.parkinglot;

import java.util.Vector;

public class GroundParking implements Parking {

    private  Vector<Transport> parkingLots = new Vector<>();

    public GroundParking(Vector<Transport> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public void parkTransport(Transport transport) {
        parkingLots.add(transport);

    }

    @Override
    public int getFreeLots() {
        return parkingLots.capacity()
                - parkingLots.size();
    }

    @Override
    public int getOccupiedLots() {
        return parkingLots.size();
    }

}
