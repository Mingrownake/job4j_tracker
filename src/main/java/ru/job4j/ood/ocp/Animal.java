package ru.job4j.ood.ocp;
/* Animal - лучше сделать interface
* Метод run - лучше сделать без явной реализации
* Наследование класса Bee от Animal - не корректно, Bee "не является" Animal
* Поле legs лучше сделать без значения, т.к. наследуется состояние */

public class Animal {

    public int legs = 4;

    public void run() {
        System.out.println("Running... ");
    }

    public static void main(String[] args) {
        Bear bear = new Bear();
        System.out.println(bear.legs);
    }
}

class Bear extends Animal {

}

class Bee extends Animal {

}
