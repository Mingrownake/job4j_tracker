package ru.job4j.ood.parkinglot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ParkingControllerTest {

    @Test
    void whenParkingControllerParksTransportThenReceivesAll() {

        ParkingController parkingController = new ParkingController();
        List<Transport> parkingLots = new ArrayList<>(3);
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1);
        Transport truck1 = new Truck(2);

        parking.parkTransport(car1);
        parking.parkTransport(truck1);

        assertThat(parkingController
                .getAllTransport())
                .containsAll(List.of(car1, truck1));
    }

    @Test
    void whenParkingControllerRemovesTransportThenReceivesNothing() {

        ParkingController parkingController = new ParkingController();
        List<Transport> parkingLots = new ArrayList<>(3);
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1);
        Transport truck1 = new Truck(2);

        parking.parkTransport(car1);
        parking.parkTransport(truck1);

        parkingController.removeAllTransport();

        assertThat(parkingController
                .getAllTransport())
                .isEmpty();
    }

    @Test
    void whenParkingIsNotFullReturnsTrue() {

        ParkingController parkingController = new ParkingController();
        List<Transport> parkingLots = new ArrayList<>(3);
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1);
        Transport car2 = new Car(1);

        parking.parkTransport(car1);

        assertThat(parkingController.hasEnoughParkingLots(car2.getSize()))
                .isTrue();
    }

    @Test
    void whenParkingIsFullReturnsFalse() {

        ParkingController parkingController = new ParkingController();
        List<Transport> parkingLots = new ArrayList<>(3);
        Parking parking = new GroundParking(parkingLots);
        Transport car1 = new Car(1);
        Transport truck1 = new Truck(2);
        Transport truck2 = new Truck(2);

        parking.parkTransport(car1);
        parking.parkTransport(truck1);

        assertThat(parkingController.hasEnoughParkingLots(truck2.getSize()))
                .isFalse();
    }
}