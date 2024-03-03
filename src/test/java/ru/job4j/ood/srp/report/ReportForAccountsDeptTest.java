package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
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

class ReportForAccountsDeptTest {
    @Test
    void whenReportIsGeneratedForAccountants() throws JAXBException {

        Store store = new MemoryStore();

        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        CurrencyConverter currencyConverter = new InMemoryCurrencyConverter();

        Currency sourceCurrency = Currency.RUB;

        Currency targetCurrency = Currency.USD;

        Report report
                = new ReportForAccountsDept(
                store, dateTimeParser,
                currencyConverter, sourceCurrency, targetCurrency);

        Employee employee
                = new Employee("Accountant1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        Employee employee1
                = new Employee("Accountant2",
                new GregorianCalendar(2023, Calendar.JANUARY, 1),
                new GregorianCalendar(2023, Calendar.JANUARY, 1),
                150);

        store.add(employee);
        store.add(employee1);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("Name; Hired; Fired; Salary; Converted Salary"
                        + System.lineSeparator()
                        + "Accountant1 01:01:2017 00:00 01:01:2017 00:00 100.0 100.0"
                        + System.lineSeparator()
                        + "Accountant2 01:01:2023 00:00 01:01:2023 00:00 150.0 150.0"
                        + System.lineSeparator());
    }
}
