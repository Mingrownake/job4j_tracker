package ru.job4j.hotchpotch;

public class Goose implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " говорит: Пшш-ш-ш-ш-ш.");
    }
}
