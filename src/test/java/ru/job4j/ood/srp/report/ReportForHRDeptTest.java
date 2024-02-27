package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportForHRDeptTest {

    @Test
    void whenReportIsGeneratedForHRsWithDiffNames() {

        Store store = new MemoryStore();

        Report report = new ReportForHRDept(store);

        Employee employee1 = new Employee(
                "HR1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                null,
                100.01);

        Employee employee2 = new Employee(
                "HR2",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                null,
                100);

        store.add(employee1);

        store.add(employee2);

        Predicate<Employee> findByE = e -> true;

        assertThat(report.generate(findByE))
                .isEqualTo("Name; Salary;"
                        + System.lineSeparator()
                        + "HR1 100.01"
                        + System.lineSeparator()
                        + "HR2 100.0"
                        + System.lineSeparator());
     }

    @Test
    void whenReportIsGeneratedForHRsWithSameNameThenOrderedBySalary() {

        Store store = new MemoryStore();

        Report report = new ReportForHRDept(store);

        Employee employee1 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100.01);
        Employee employee2 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        store.add(employee1);

        store.add(employee2);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("Name; Salary;"
                        + System.lineSeparator()
                        + "HR 100.01"
                        + System.lineSeparator()
                        + "HR 100.0"
                        + System.lineSeparator());
    }

    @Test
    void whenReportIsGeneratedForHRsWithSameNameThenOrderedBySalaryJSON() {

        Store store = new MemoryStore();

        Gson gson = new GsonBuilder().create();

        Report report = new ReportForHRDept(store, gson);

        Employee employee1 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100.01);

        Employee employee2 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        store.add(employee1);

        store.add(employee2);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generateJsonRep(findEmployee))
                .isEqualTo("[{\"name\":\"HR\","
                        + "\"hired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                        + "\"fired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                        + "\"salary\":100.01},"
                        + "{\"name\":\"HR\","
                        + "\"hired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                        + "\"fired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                        + "\"salary\":100.0}]");
    }
}