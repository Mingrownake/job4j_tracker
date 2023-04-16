package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FullSearchTest {

    @Test
    public void extractNumber1() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(tasks)).containsAll(expected);
    }

    @Test
    public void extractNumbers2() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First task"),
                new Task("1", "First task")
        );
        Set<String> expected = new HashSet<>(List.of("1"));
        assertThat(FullSearch.extractNumber(tasks)).containsAll(expected);
    }
}