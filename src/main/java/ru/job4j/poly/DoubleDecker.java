package ru.job4j.poly;

public class DoubleDecker implements Transport {
    @Override
    public void ride() {
        System.out.println("Катается по туристическому марштруту.");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println("Вместимость " + passenger + " чел.");
    }

    @Override
    public void fillUpPrice(double litres) {
        Transport.super.fillUpPrice(litres);
    }
}
