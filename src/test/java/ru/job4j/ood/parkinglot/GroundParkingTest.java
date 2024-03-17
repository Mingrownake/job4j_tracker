package ru.job4j.ood.parkinglot;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class GroundParkingTest {

    @Test
    void whenThereIsOneFreeLotThenReceiveOneFree() {

        Transport[] parkingLots = new Transport[2];

        Parking parking = new GroundParking(parkingLots);

        ParkingController parkingController = new ParkingController(parking);

        Transport car1 = new Car(1, 1);

        parkingController.parkTransport(car1);

        assertThat(parking.getFreeLots()).isEqualTo(1);
    }

    @Test
    void whenThereIsNoFreeLotThenReceiveZeroFree() {

        Transport[] parkingLots = new Transport[2];

        Parking parking = new GroundParking(parkingLots);

        ParkingController parkingController = new ParkingController(parking);

        Transport car1 = new Car(1, 1);
        Transport car2 = new Car(2, 1);

        parkingController.parkTransport(car1);
        parkingController.parkTransport(car2);

        assertThat(parking.getFreeLots()).isEqualTo(0);
    }

    @Test
    void whenThereIsOneLotOccupiedThenReceiveOneOccupied() {

        Transport[] parkingLots = new Transport[10];

        Parking parking = new GroundParking(parkingLots);

        ParkingController parkingController = new ParkingController(parking);

        Transport car1 = new Car(1, 1);

        parkingController.parkTransport(car1);

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

        ParkingController parkingController = new ParkingController(parking);

        Transport truck1 = new Truck(1, 2);
        Transport truck2 = new Truck(2, 2);
        Transport car1 = new Car(1, 1);

        parkingController.parkTransport(car1);
        parkingController.parkTransport(truck1);
        parkingController.parkTransport(truck2);

        assertThat(parking.getOccupiedLots()).isEqualTo(5);

    }
}
