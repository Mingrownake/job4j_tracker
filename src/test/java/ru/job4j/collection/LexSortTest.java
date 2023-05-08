package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }

    @Test
    public void sortNum1and2and3and5and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task.",
                "5. Task.",
                "3. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "3. Task.",
                "5. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }
}