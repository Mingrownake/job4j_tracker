package ru.job4j.fabric;

public class Round implements Shape {
    int r;

    public Round(int r) {
        this.r = r;
    }

    @Override
    public String draw() {
        return "O";
    }

    @Override
    public double square() {
        return Math.PI * Math.pow(r, 2);
    }
}

