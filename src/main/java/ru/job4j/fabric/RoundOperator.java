package ru.job4j.fabric;

import java.util.Scanner;

public class RoundOperator extends  ShapeOperator {
    private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.print("Введите радиус круга: ");
        int r = Integer.parseInt(input.nextLine());
        return new Round(r);
    }
}
