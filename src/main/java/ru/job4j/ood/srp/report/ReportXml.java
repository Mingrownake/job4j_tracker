package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReportXml implements Report {
    private final Store store;

    private JAXBContext context;

    public ReportXml(Store store,
                      JAXBContext context) {
        this.store = store;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {

        List<Employee> employeeList = new ArrayList<>(store.findBy(filter));

        JAXBContext context = JAXBContext.newInstance(Employee.Employees.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employee.Employees(employeeList), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
