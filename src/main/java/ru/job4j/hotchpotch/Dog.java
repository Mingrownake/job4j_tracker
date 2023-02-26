package ru.job4j.hotchpotch;

public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " говорит: Гав-гав.");
    }
}
