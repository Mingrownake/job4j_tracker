package ru.job4j.oop;

public class Wolf {

    private boolean runResult;

    public void setCondition(boolean condition) {
        this.runResult = condition;
    }

    public void eat(Girl girl) {

    }

    public void tryEat(Ball ball) {
        ball.tryRun(runResult);
    }
}
