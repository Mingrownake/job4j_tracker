package ru.job4j.polymorph;

public interface Vehicle extends Fuel {

    int WHEELS = 4; // = public static final int WHEELS = 4;
    String STEERWHEEL = "round";

    void accelerate();

    void brake();

    void steer();

    void changeGear();

    static void getDragCoefficient() {
        System.out.println("Формула расчета "
               + "коэффициента аэродинамического сопротивления автомобиля");
    }

    static void getBrakingPath() {
        System.out.println("Расчёт тормозного пути.");
    }

    default void chargeBattery() {
        System.out.println("Аккумулятор под капотом. Зарядить.");
    }

    default void chargeBatteryTime() {
        System.out.println("Время зарядки батареи 1 час.");
    }

}
