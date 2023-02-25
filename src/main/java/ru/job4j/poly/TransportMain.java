package ru.job4j.poly;

public class TransportMain {
    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.passengers(50);
        bus.ride();
        bus.fillUpPrice(20);

        Transport doubleD = new DoubleDecker();
        doubleD.passengers(100);
        doubleD.ride();
        doubleD.fillUpPrice(1);
    }
}
