package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportForDevDeptTest {

    @Test
    void whenGenerateReportForDevs() throws JAXBException {

        Store store = new MemoryStore();

        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        Report report = new ReportForDevDept(store, dateTimeParser);

        Employee employee
                = new Employee("Dev1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        Employee employee1
                = new Employee("Dev2",
                new GregorianCalendar(2024, Calendar.JANUARY, 10),
                new GregorianCalendar(2024, Calendar.JANUARY, 15),
                100);

        store.add(employee);
        store.add(employee1);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("Name; Hired; Fired; Salary;"
                            + System.lineSeparator()
                            + "Dev1;2017-01-01T00:00:00.000+07:00;2017-01-01T00:00:00.000+07:00;100.0"
                            + System.lineSeparator()
                            + "Dev2;2024-01-10T00:00:00.000+07:00;2024-01-15T00:00:00.000+07:00;100.0"
                            + System.lineSeparator());
    }
}