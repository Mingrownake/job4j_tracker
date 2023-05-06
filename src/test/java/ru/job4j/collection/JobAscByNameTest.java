package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JobAscByNameTest {

    @Test
    public void whenJobsAreSortedbyNameAsc() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Fix bugs", 1),
                new Job("Code review", 3),
                new Job("Do nothing", 2)
        ));
        List<Job> expected = new ArrayList<>(List.of(
                new Job("Code review", 3),
                new Job("Do nothing", 2),
                new Job("Fix bugs", 1)
        ));
        Collections.sort(jobs, new JobAscByName());
        assertEquals(jobs, expected);
    }
}