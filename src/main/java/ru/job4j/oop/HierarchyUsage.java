package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        /* создаем объекта класса Car. */
        Car2 car = new Car2();
        /* делаем приведение к типу родителя Transport. */
        Transport tp = car;
        /* делаем приведение к типу родителя Object. */
        Object obj = car;
        /* Приведение типа при создании объекта. */
        Object ocar = new Car2();
        /* Приведение типа за счет понижения по иерархии. */
        Car2 carFromObject = (Car2) ocar;

        /* Ошибка в приведении типа. */
        Object bicycle = new Bicycle();
        Car2 cb = (Car2) bicycle; // код завершится с ошибкой приведения типов ClassCastException
    }
}
