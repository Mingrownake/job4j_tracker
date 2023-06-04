package ru.job4j.lambda;

@FunctionalInterface
public interface FuncInterface {
    /**
     * * @param s - строка
     * @return returns объект типа Model
     * abstract method
     */
    Model function(String s);
}
