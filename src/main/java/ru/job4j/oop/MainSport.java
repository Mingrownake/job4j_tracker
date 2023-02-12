package ru.job4j.oop;

public class MainSport {
    public static void main(String[] args) {
        FootballPlayer footballPlayer = new FootballPlayer();
        footballPlayer.footKick();
        footballPlayer.run();
        Athlete athlete = new Athlete();
        athlete.sprint();
        athlete.run();
    }
}
