package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = new Random().nextBoolean();
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            if (count >= 3) {
                System.out.println(player + " введите число от 1 до 3:");
                int matches = Integer.parseInt(input.nextLine());
                if (matches >= 1 && matches <= 3) {
                    count -= matches;
                    turn = !turn;
                    System.out.println("Осталось " + count + " спичек");
                } else {
                    System.out.println("Ошибочка.");
                }
            } else {
                System.out.println(player + " введите число от 1 до " + count + " :");
                int matches = Integer.parseInt(input.nextLine());
                if (matches >= 1 && matches <= count) {
                    count -= matches;
                    turn = !turn;
                    System.out.println("Осталось " + count + " спичек");
                } else {
                    System.out.println("Ошибочка.");
                }
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}