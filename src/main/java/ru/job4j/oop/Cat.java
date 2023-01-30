package ru.job4j.oop;

public class Cat {
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    private String food;

    public void eat(String meat) {
        this.food = meat;
    }

    public void show() {
        System.out.println(this.food);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        System.out.println("Here are cat's food and name");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("Here are cat's food and name");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}