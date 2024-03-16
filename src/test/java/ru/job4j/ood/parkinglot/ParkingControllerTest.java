package ru.job4j.ood.parkinglot;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParkingControllerTest {

    @Test
    void whenParkingControllerParksTransportThenReceivesAll() {

        Transport[] parkingLots = new Transport[3];

        Parking parking = new GroundParking(parkingLots);

        ParkingController parkingController = new ParkingController(parking);

        Transport car1 = new Car(1, 1);
        Transport truck1 = new Truck(1, 2);

        parkingController.parkTransport(car1);
        parkingController.parkTransport(truck1);

        assertThat(parkingController
                .getAllTransport())
                .containsAll(List.of(car1, truck1));
    }

    @Test
    void whenParkingControllerRemovesTransportThenDoesntReceiveIt() {

        Transport[] parkingLots = new Transport[10];

        Parking groundParking = new GroundParking(parkingLots);

        ParkingController parkingController = new ParkingController(groundParking);

        Transport truck1 = new Truck(1, 2);
        Transport truck2 = new Truck(2, 2);
        Transport car1 = new Car(1, 1);

        parkingController.parkTransport(car1);
        parkingController.parkTransport(truck1);
        parkingController.parkTransport(truck2);

        parkingController.removeAllTransport();

        Assumptions.assumeFalse(parkingController.getAllTransport()
                .containsAll(List.of(car1, truck1, truck2)));
    }

    @Test
    void whenParkingIsNotFullReturnsTrue() {

        Transport[] parkingLots = new Transport[10];

        Parking groundParking = new GroundParking(parkingLots);

        ParkingController parkingController = new ParkingController(groundParking);

        Transport car1 = new Car(1, 1);

        assertThat(parkingController.hasEnoughParkingLots(car1))
                .isTrue();

    }

    @Test
    void whenParkingIsFullReturnsFalse() {

        Transport[] parkingLots = new Transport[1];

        Parking groundParking = new GroundParking(parkingLots);

        ParkingController parkingController = new ParkingController(groundParking);

        Transport truck1 = new Truck(2, 3);

        assertThat(parkingController.hasEnoughParkingLots(truck1))
                .isFalse();
    }
}

