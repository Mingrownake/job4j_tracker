package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JobAscByPriorityTest {
    @Test
    public void whenJobsAreSortedByPriorityAsc() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Create merge request", 3),
                new Job("Perform code review", 5),
                new Job("Drink beer", 2)
        ));
        List<Job> expected = new ArrayList<>(List.of(
                new Job("Drink beer", 2),
                new Job("Create merge request", 3),
                new Job("Perform code review", 5)
        ));
        Collections.sort(jobs, new JobAscByPriority());
        assertEquals(jobs, expected);
    }

}