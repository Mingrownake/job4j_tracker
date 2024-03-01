package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportForHRDeptTest {

    @Test
    void whenReportIsGeneratedForHRsWithDiffNames() throws JAXBException {

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
    void whenReportIsGeneratedForHRsWithSameNameThenOrderedBySalary() throws JAXBException {
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
}
