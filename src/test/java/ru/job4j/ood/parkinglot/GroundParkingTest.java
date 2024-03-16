package ru.job4j.ood.parkinglot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.assertj.core.api.Assertions.*;

class GroundParkingTest {

    @Test
    void whenThereIsOneFreeLotThenReceiveOneFree() {

        Transport[] parkingLots = new Transport[2];
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1, 1);

        parking.parkTransport(car1);

        assertThat(parking.getFreeLots()).isEqualTo(1);
    }

    @Test
    void whenThereIsNoFreeLotThenReceiveZeroFree() {

        Transport[] parkingLots = new Transport[2];

        Parking parking = new GroundParking(parkingLots);

        Transport car1 = new Car(1, 1);

        Transport car2 = new Car(1, 1);

        parking.parkTransport(car1);

        parking.parkTransport(car2);

        assertThat(parking.getFreeLots()).isEqualTo(0);
    }

    @Test
    void whenThereIsOneLotOccupiedThenReceiveOneOccupied() {

        Transport[] parkingLots = new Transport[10];

        Parking parking = new GroundParking(parkingLots);

        Transport car1 = new Car(1, 1);

        parking.parkTransport(car1);

        assertThat(parking.getOccupiedLots()).isEqualTo(1);
    }

    @Test
    void whenThereIsNoLotOccupiedThenReceiveZeroFree() {

        Transport[] parkingLots = new Transport[1];

        Parking parking = new GroundParking(parkingLots);

        assertThat(parking.getOccupiedLots()).isEqualTo(0);
    }

    @Test
    void whenThereAreFiveLotsOccupiedThenReceiveFiveFree() {

        Transport[] parkingLots = new Transport[10];

        Parking parking = new GroundParking(parkingLots);

        Transport truck1 = new Truck(1, 5);

        parking.parkTransport(truck1);

        assertThat(parking.getOccupiedLots()).isEqualTo(5);

    }
}