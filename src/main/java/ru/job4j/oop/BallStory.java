package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Hair hair = new Hair();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        Ball ball = new Ball();
        hair.setCondition(true);
        fox.setCondition(true);
        wolf.setCondition(false);
        hair.tryEat(ball);
        fox.tryEat(ball);
        wolf.tryEat(ball);
    }
}
