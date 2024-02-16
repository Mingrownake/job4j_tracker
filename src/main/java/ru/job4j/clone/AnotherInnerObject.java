package ru.job4j.clone;

public class AnotherInnerObject {
    int num;

    @Override
    protected AnotherInnerObject clone() throws CloneNotSupportedException {
        return (AnotherInnerObject) super.clone();
    }
}
