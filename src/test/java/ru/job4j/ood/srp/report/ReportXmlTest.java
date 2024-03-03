package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
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
        
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();

        Store store = new MemoryStore();

        Calendar now = Calendar.getInstance();

        JAXBContext context = JAXBContext.newInstance(Employee.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Report report = new ReportXml(store);

        Employee employee = new Employee("Employee",
                now,
                now,
                100);

        Employee employee1 = new Employee("Employee1",
                now,
                now,
                100.101);

        store.add(employee);
        store.add(employee1);

        String date = dateTimeParser.parse(now);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("""
                        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                        <employees>
                            <employee>
                                <name>Employee</name>
                                <hired>%s</hired>
                                <fired>%s</fired>
                                <salary>100.0</salary>
                            </employee>
                            <employee>
                                <name>Employee1</name>
                                <hired>%s</hired>
                                <fired>%s</fired>
                                <salary>100.101</salary>
                            </employee>
                        </employees>
                        """, date, date, date, date
                );

    }
}