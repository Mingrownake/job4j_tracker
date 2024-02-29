package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;
/**
class ReportForHRDeptTest {

    @Test
    void whenReportIsGeneratedForHRsWithDiffNames() throws JAXBException {

        Store store = new MemoryStore();

        Report report = new ReportForHRDept(store);

        Employee employee1 = new Employee(
                "HR1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                null,
                100.01, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));

        Employee employee2 = new Employee(
                "HR2",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                null,
                100, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));

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
                100.01, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));
        Employee employee2 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));

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
    void whenReportIsGeneratedForHRsWithSameNameThenOrderedBySalaryJSON() throws JAXBException {

        Store store = new MemoryStore();

        Gson gson = new GsonBuilder().create();

        Report report = new ReportForHRDept(store, gson);

        Employee employee1 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100.01, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));

        Employee employee2 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));

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

    @Test
    void whenReportIsGeneratedForHRsWithSameNameThenOrderedBySalaryXML() throws JAXBException {

        Store store = new MemoryStore();

        JAXBContext context = JAXBContext.newInstance(Employee.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Report report = new ReportForHRDept(store, context);

        Employee employee1 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100.01, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));

        Employee employee2 = new Employee("HR",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100, inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency));

        store.add(employee1);

        store.add(employee2);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generateXMLRep(findEmployee))
                .isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                                + "<employees>\n"
                                + "    <employee>\n"
                                + "        <fired>2017-01-01T00:00:00+07:00</fired>\n"
                                + "        <hired>2017-01-01T00:00:00+07:00</hired>\n"
                                + "        <name>HR</name>\n"
                                + "        <salary>100.01</salary>\n"
                                + "    </employee>\n"
                                + "    <employee>\n"
                                + "        <fired>2017-01-01T00:00:00+07:00</fired>\n"
                                + "        <hired>2017-01-01T00:00:00+07:00</hired>\n"
                                + "        <name>HR</name>\n"
                                + "        <salary>100.0</salary>\n"
                                + "    </employee>\n"
                                + "</employees>\n"
                                + ""

                        );
    }
}
 */