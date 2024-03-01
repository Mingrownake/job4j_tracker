package ru.job4j.ood.srp.report;

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

class ReportXmlTest {
    @Test
    void whenJsonReportIsGenerated() throws JAXBException {

        Store store = new MemoryStore();

        JAXBContext context = JAXBContext.newInstance(Employee.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Report report = new ReportXml(store, context);
        Employee employee = new Employee("Employee",
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                new GregorianCalendar(2017, Calendar.JANUARY, 1),
                100);

        store.add(employee);

        Predicate<Employee> findEmployee = e -> true;

        assertThat(report.generate(findEmployee))
                .isEqualTo("""
                        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                        <employees>
                            <employee>
                                <fired>2017-01-01T00:00:00+07:00</fired>
                                <hired>2017-01-01T00:00:00+07:00</hired>
                                <name>Employee</name>
                                <salary>100.0</salary>
                            </employee>
                        </employees>
                        """
                );

    }
}