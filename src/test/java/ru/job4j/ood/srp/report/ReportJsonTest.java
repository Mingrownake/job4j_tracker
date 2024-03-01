package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        Gson gson = new GsonBuilder().create();
        Report report = new ReportJson(store, gson);
        Employee employee = new Employee("Employee",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);
        store.add(employee);
        Predicate<Employee> findEmployee = e -> true;
        assertThat(report.generate(findEmployee))
                .isEqualTo("[{\"name\":\"Employee\","
                        + "\"hired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                       + "\"fired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                        + "\"salary\":100.0}]");

    }

}