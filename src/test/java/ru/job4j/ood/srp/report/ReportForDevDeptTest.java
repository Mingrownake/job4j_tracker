package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportForDevDeptTest {

    @Test
    void whenGenerateReportForDevs() {
        Store store = new MemoryStore();

        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        ReportForDevDept report =
                new ReportForDevDept(store, dateTimeParser);

        Employee employee1
                = new Employee("Dev1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);
        store.add(employee1);

        Predicate<Employee> findByE = e -> e.equals(e);

        assertThat(report.generate(findByE))
                .isEqualTo("Name; Hired; Fired; Salary;"
                            + System.lineSeparator()
                            + "Dev1;01:01:2017 00:00;01:01:2017 00:00;100.0"
                            + System.lineSeparator());
    }

}