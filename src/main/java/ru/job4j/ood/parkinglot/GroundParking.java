package ru.job4j.ood.parkinglot;

public class GroundParking implements Parking {

    private Transport[] parkingLots;

    private int freeLotIndex; /*Свободное место, с кторого начинать парковать */

    public GroundParking(Transport[] parkingLots) {
        this.parkingLots = parkingLots;
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

    public Transport[] getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(Transport[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public int getFreeLotIndex() {
        return freeLotIndex;
    }

    @Override
    public void setNewFreeLotIndex(int updatedFreeLotIndex) {
        this.freeLotIndex = updatedFreeLotIndex;
    }
}
