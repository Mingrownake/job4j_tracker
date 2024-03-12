package ru.job4j.ood.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class GroundParking implements Parking {

    private List<Transport> parkingLots = new ArrayList<>();

    public GroundParking(List<Transport> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public void parkTransport(Transport transport) {

    }

    @Override
    public int getFreeLots() {
        return 0;
    }

    @Override
    public int getOccupiedLots() {
        return 0;
    }

}
