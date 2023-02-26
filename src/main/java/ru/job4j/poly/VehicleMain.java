package ru.job4j.poly;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle autobusSmall = new Autobus();
        Vehicle autobusLarge = new Autobus();
        Vehicle airplaneTiny = new Airplane();
        Vehicle airplaneHuge = new Airplane();
        Vehicle trainMedium = new Train();
        Vehicle trainSmall = new Train();

        Vehicle[] vehicles = new Vehicle[]{autobusSmall, autobusLarge, airplaneTiny,
                airplaneHuge, trainMedium, trainSmall};
        for (Vehicle v : vehicles) {
            v.move();
            v.maxSpeed();
            v.madeOf();
        }
    }
}