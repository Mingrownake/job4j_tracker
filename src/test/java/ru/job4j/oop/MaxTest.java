package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax3To2Then3() {
        int left = 3;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax1To1Then1() {
        int left = 1;
        int right = 1;
        int result = Max.max(left, right);
        int expected = 1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax5To0And1Then5() {
        int left = 0;
        int right = 1;
        int last = 5;
        int result = Max.max(left, right, last);
        int expected = 5;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax3To0And1Then3() {
        int left = 1;
        int right = 3;
        int last = 0;
        int result = Max.max(left, right, last);
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax15To2And5And10Then15() {
        int left = 15;
        int right = 2;
        int last = 5;
        int first = 10;
        int result = Max.max(left, right, last, first);
        int expected = 15;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax10To2And5And7Then10() {
        int left = 7;
        int right = 2;
        int last = 5;
        int first = 10;
        int result = Max.max(left, right, last, first);
        int expected = 10;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax100To2And5And7And8Then100() {
        int left = 7;
        int right = 2;
        int last = 5;
        int first = 10;
        int second = 100;
        int result = Max.max(second, left, right, last, first);
        int expected = 100;
        assertThat(result).isEqualTo(expected);
    }
}
