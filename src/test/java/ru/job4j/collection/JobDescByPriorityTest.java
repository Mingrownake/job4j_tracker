package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JobDescByPriorityTest {
    @Test
    public void whenJobsAreSortedByPriorityDesc() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Find bugs", 3),
                new Job("Refactor code", 4),
                new Job("Test code", 1)
        ));
        List<Job> expected = new ArrayList<>(List.of(
                new Job("Test code", 1),
                new Job("Find bugs", 3),
                new Job("Refactor code", 4)
        ));
        Collections.sort(jobs, new JobAscByPriority());
        assertEquals(jobs, expected);
    }
}