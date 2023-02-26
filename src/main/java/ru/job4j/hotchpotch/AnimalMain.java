package ru.job4j.hotchpotch;

public class AnimalMain {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal guineaPig = new GuineaPig();
        dog.sound();
        guineaPig.sound();
        Dog psina = (Dog) dog;
        GuineaPig svinota = (GuineaPig) guineaPig;
    }
}
