package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportJsonTest {
    @Test
    void whenJsonReportIsGenerated() throws JAXBException {

        Store store = new MemoryStore();

        Report report = new ReportJson(store, new Gson());

        Employee employee = new Employee("Employee",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        Employee employee1 = new Employee("Employee",
                new GregorianCalendar(2023, Calendar.DECEMBER, 31),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31),
                200.01);

        store.add(employee);
        store.add(employee1);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("""
                        [
                          {
                            "name": "Employee",
                            "hired": {
                              "year": 2017,
                              "month": 0,
                              "dayOfMonth": 1,
                              "hourOfDay": 0,
                              "minute": 0,
                              "second": 0
                            },
                            "fired": {
                              "year": 2017,
                              "month": 0,
                              "dayOfMonth": 1,
                              "hourOfDay": 0,
                              "minute": 0,
                              "second": 0
                            },
                            "salary": 100.0
                          },
                          {
                            "name": "Employee",
                            "hired": {
                              "year": 2023,
                              "month": 11,
                              "dayOfMonth": 31,
                              "hourOfDay": 0,
                              "minute": 0,
                              "second": 0
                            },
                            "fired": {
                              "year": 2024,
                              "month": 11,
                              "dayOfMonth": 31,
                              "hourOfDay": 0,
                              "minute": 0,
                              "second": 0
                            },
                            "salary": 200.01
                          }
                        ]""");

    }

}