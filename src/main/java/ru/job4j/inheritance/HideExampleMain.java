package ru.job4j.inheritance;

public class HideExampleMain {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cat = new Catt();
        animal.instanceInvoke();
        cat.instanceInvoke();
        Animal.staticInvoke();
        Catt.staticInvoke();
        System.out.println("============");
        cat.instanceInvoke();
        Animal other = null;
        other.instanceInvoke();
        Catt kitty = new Catt();
        kitty.instanceInvoke();
    }
}
