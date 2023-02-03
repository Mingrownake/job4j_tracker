package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(2, 0);
        double out = firstPoint.distance(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00to00then0() {
        double expected = 0;
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(0, 0);
        double out = firstPoint.distance(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when11to11then0() {
        double expected = 0;
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(1, 1);
        double out = firstPoint.distance(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenminus1minus1tominus1minus1then0() {
        double expected = 0;
        Point firstPoint = new Point(-1, -1);
        Point secondPoint = new Point(-1, -1);
        double out = firstPoint.distance(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when1to1to1And1to1to1then0() {
        double expected = 0;
        Point firstPoint = new Point(1, 1, 1);
        Point secondPoint = new Point(1, 1, 1);
        double out = firstPoint.distance3d(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when5to4to3And8to7to5then0() {
        double expected = 5.19;
        Point firstPoint = new Point(5, 4, 3);
        Point secondPoint = new Point(8, 7, 6);
        double out = firstPoint.distance3d(secondPoint);
        Assert.assertEquals(expected, out, 0.01);
    }
}