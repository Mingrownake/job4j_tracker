package ru.job4j.ood.parkinglot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GroundParkingTest {

    @Test
    void whenThereIsOneFreeLotThenReceiveOne() {

        List<Transport> parkingLots = new ArrayList<>(2);
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1);

        parking.parkTransport(car1);

        assertThat(parking.getFreeLots()).isEqualTo(1);
    }

    @Test
    void whenThereIsNoFreeLotThenReceiveZero() {

        List<Transport> parkingLots = new ArrayList<>(2);
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1);
        Transport car2 = new Car(1);

        parking.parkTransport(car1);
        parking.parkTransport(car2);

        assertThat(parking.getFreeLots()).isEqualTo(0);
    }

    @Test
    void whenThereIsOneLotOccupiedThenReceiveOne() {

        List<Transport> parkingLots = new ArrayList<>(1);
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1);

        parking.parkTransport(car1);

        assertThat(parking.getFreeLots()).isEqualTo(1);
    }

    @Test
    void whenThereIsNoLotOccupiedThenReceiveZero() {

        List<Transport> parkingLots = new ArrayList<>(1);
        Parking parking = new GroundParking(parkingLots);

        assertThat(parking.getOccupiedLots()).isEqualTo(0);
    }

}