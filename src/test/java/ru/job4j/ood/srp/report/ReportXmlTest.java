package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.XmlReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.util.*;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportXmlTest {
    @Test
    void whenXmlReportIsGenerated() throws JAXBException {

        Store store = new MemoryStore();

        Calendar now = Calendar.getInstance();

        DateTimeParser<Calendar> parser = new XmlReportDateTimeParser();

        JAXBContext context = JAXBContext.newInstance(Employee.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Report report = new ReportXml(store);

        Employee employee = new Employee("Employee",
                now,
                now,
                100);

        store.add(employee);

        String date = parser.parse(now);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("""
                        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                        <employees>
                            <employee>
                                <fired>%s</fired>
                                <hired>%s</hired>
                                <name>Employee</name>
                                <salary>100.0</salary>
                            </employee>
                        </employees>
                        """, date, date
                );

    }
}