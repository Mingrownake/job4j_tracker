package ru.job4j.oop;

public class Fox {

    private boolean runResult;

    public void setCondition(boolean condition) {
        this.runResult = condition;
    }

    public void tryEat(Ball ball) {
        ball.tryRun(runResult);
    }
}
