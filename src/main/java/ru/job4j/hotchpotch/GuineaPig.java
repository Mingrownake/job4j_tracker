package ru.job4j.hotchpotch;

public class GuineaPig implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " говорит: Пиу-пиу.");
    }
}