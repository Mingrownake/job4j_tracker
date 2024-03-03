package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportForDevDeptTest {

    @Test
    void whenGenerateReportForDevs() throws JAXBException {

        Store store = new MemoryStore();

        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        Report report = new ReportForDevDept(store, dateTimeParser);

        Calendar now =  Calendar.getInstance();

        Employee employee
                = new Employee("Dev1",
                now,
                now,
                100);

        Employee employee1
                = new Employee("Dev2",
                now,
                now,
                100);

        String date = dateTimeParser.parse(now);

        store.add(employee);
        store.add(employee1);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("Name; Hired; Fired; Salary;"
                            + System.lineSeparator()
                            + "Dev1;%s;%s;100.0"
                            + System.lineSeparator()
                            + "Dev2;%s;%s;100.0"
                            + System.lineSeparator(), date, date, date, date);
    }
}