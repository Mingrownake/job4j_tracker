package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
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

class ReportForDevDeptTest {

    @Test
    void whenGenerateReportForDevs() throws JAXBException {

        Store store = new MemoryStore();

        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        Report report = new ReportForDevDept(store, dateTimeParser);

        Employee employee1
                = new Employee("Dev1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        store.add(employee1);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("Name; Hired; Fired; Salary;"
                            + System.lineSeparator()
                            + "Dev1;01:01:2017 00:00;01:01:2017 00:00;100.0"
                            + System.lineSeparator());
    }

    @Test
    void whenGenerateReportForDevsJSON() throws JAXBException {

        Store store = new MemoryStore();

        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        Gson gson = new GsonBuilder().create();

        Report report = new ReportForDevDept(store, dateTimeParser, gson);

        Employee employee1 = new Employee("Dev1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        store.add(employee1);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generateJsonRep(findEmployee))
                .isEqualTo("[{\"name\":\"Dev1\","
                        + "\"hired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                        + "\"fired\":{\"year\":2017,\"month\":0,\"dayOfMonth\":1,\"hourOfDay\":0,\"minute\":0,\"second\":0},"
                        + "\"salary\":100.0}]");
    }

    @Test
    void whenReportIsGeneratedForDevsXML() throws JAXBException {

        Store store = new MemoryStore();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        JAXBContext context = JAXBContext.newInstance(Employee.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Report report = new ReportForDevDept(store, dateTimeParser, context);

        Employee employee1 = new Employee("Dev1",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        store.add(employee1);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generateXMLRep(findEmployee))
                .isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                        + "<employees>\n"
                        + "    <employee>\n"
                        + "        <fired>2017-01-01T00:00:00+07:00</fired>\n"
                        + "        <hired>2017-01-01T00:00:00+07:00</hired>\n"
                        +  "        <name>Dev1</name>\n"
                        + "        <salary>100.0</salary>\n"
                        + "    </employee>\n"
                        + "</employees>\n"
                        + ""
                );
    }
}