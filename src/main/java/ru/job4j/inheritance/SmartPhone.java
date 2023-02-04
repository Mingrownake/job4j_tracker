package ru.job4j.inheritance;

public class SmartPhone extends Phone {
    public boolean canBeChargedByUsb() {
        return true;
    }

    public static void main(String[] args) {
        Phone oldPhone = new Phone();
        SmartPhone xiaomiPhone = new SmartPhone();
        System.out.println(oldPhone.canBeChargedByUsb());
        System.out.println(oldPhone.canRing());
        System.out.println(xiaomiPhone.canBeChargedByUsb());
        System.out.println(xiaomiPhone.canRing());
    }
}
