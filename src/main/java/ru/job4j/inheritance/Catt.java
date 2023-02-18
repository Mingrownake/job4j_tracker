package ru.job4j.inheritance;

public class Catt extends Animal {
    @Override
    public void instanceInvoke() {
        System.out.println("Вызов метода экземпляра Catt");
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Catt");
    }
}
