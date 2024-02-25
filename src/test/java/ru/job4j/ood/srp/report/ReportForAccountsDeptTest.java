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

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportForAccountsDeptTest {
    @Test
    void whenReportIsGeneratedForAccountants() {
        Store store = new MemoryStore();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        CurrencyConverter currencyConverter = new InMemoryCurrencyConverter();
        Currency sourceCurrency = Currency.RUB;
        Currency targetCurrency = Currency.USD;

        ReportForAccountsDept report
                = new ReportForAccountsDept(
                        store, dateTimeParser,
                        currencyConverter, sourceCurrency, targetCurrency);

        Employee employee1
                = new Employee("Accountant",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);
        store.add(employee1);
        Predicate<Employee> findByE = e -> e.equals(e);
        //store.findBy(findByE);
        assertThat(report.generate(findByE))
                .isEqualTo("Name; Hired; Fired; Salary; Converted Salary"
                        + System.lineSeparator()
                        + "Accountant 01:01:2017 00:00 01:01:2017 00:00 100.0 1.6199999999999999"
                        + System.lineSeparator());
    }

}