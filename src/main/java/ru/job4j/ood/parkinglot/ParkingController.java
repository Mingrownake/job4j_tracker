package ru.job4j.ood.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingController {

    private Parking groundParking;

    public ParkingController(Parking groundParking) {
        this.groundParking = groundParking;
    }

    public boolean hasEnoughParkingLots(Transport transport) {
        return  groundParking.getFreeLots() >= transport.getSize();
    }

    public List<Transport> getAllTransport() {
        return new ArrayList<>(Arrays.asList(groundParking.getParkingLots()));
    }

    public void removeAllTransport() {
        for (int i = 0; i < groundParking.getParkingLots().length; i++) {
            if (groundParking.getParkingLots()[i] != null) {
                groundParking.getParkingLots()[i] = null;
            }
        }
    }

    public void parkTransport(Transport transport) {
        if (hasEnoughParkingLots(transport)) {
            int index = groundParking.getFreeLotIndex();
            for (int i = index; i < transport.getSize() + index; i++) {
                groundParking.getParkingLots()[i] = transport;
                i++;
                index++;
            }
            groundParking.setNewFreeLotIndex(index);
        }

    }
}
