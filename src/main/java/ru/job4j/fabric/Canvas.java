package ru.job4j.fabric;

import java.util.Scanner;

public class Canvas {
    private ShapeOperator shapeOperator;

    public Canvas(ShapeOperator shapeOperator) {
        this.shapeOperator = shapeOperator;
    }

    public void demonstrate() {
        this.shapeOperator.showInfo();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeOperator operator = null;
        System.out.println("Какую фигуру вы хотите построить: ");
        String ans = input.nextLine();
        if ("прямоугольник".equals(ans)) {
            operator = new RectangleOperator();
        }
        if ("треугольник".equals(ans)) {
            operator = new TriangleOperator();
        }
        if ("круг".equals(ans)) {
            operator = new RoundOperator();
        }
        Canvas canvas = new Canvas(operator);
        canvas.demonstrate();
    }
}
