package ru.job4j.hotchpotch;

public class Cow implements Animal {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " говорит: Му-му.");
    }
}
