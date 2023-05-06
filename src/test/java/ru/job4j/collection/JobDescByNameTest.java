package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JobDescByNameTest {

    @Test
    public void whenJobsAreSortedByNameDesc() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Drink beer", 1),
                new Job("Code review", 3),
                new Job("Skype call", 2)
        ));
        List<Job> expected = new ArrayList<>(List.of(
                new Job("Skype call", 2),
                new Job("Drink beer", 1),
                new Job("Code review", 3)
        ));
        Collections.sort(jobs, new JobDescByName());
        assertEquals(jobs, expected);
    }
}