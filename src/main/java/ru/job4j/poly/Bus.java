package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Катается по марштруту.");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println("Вместимость " + passenger + " чел.");
    }

    @Override
    public void fillUpPrice(double litres) {
        System.out.println("Стоимость за " + litres
                + " литр/а/ов равна " + litres * 99 + " рублей.");
    }
}