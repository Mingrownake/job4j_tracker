package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.store.Store;
import ru.job4j.ood.srp.model.Employee;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.function.Predicate;

public class ReportForHRDept implements Report {
    private final Store store;
    private JAXBContext context = JAXBContext.newInstance(Employee.class);

    private Gson gson = new GsonBuilder().create();

    public ReportForHRDept(Store store) throws JAXBException {
        this.store = store;
    }

    public ReportForHRDept(Store store, Gson gson) throws JAXBException {
        this.store = store;
        this.gson = gson;
    }

    public ReportForHRDept(Store store, JAXBContext context) throws JAXBException {
        this.store = store;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());

        List<Employee> employeeList = new ArrayList<>(store.findBy(filter));

        List<Employee> sortedList = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();

        for (Employee employee : sortedList) {
            text.append(employee.getName())
                    .append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    @Override
    public String generateJsonRep(Predicate<Employee> filter) {

        List<Employee> employeeList = new ArrayList<>(store.findBy(filter));

        List<Employee> sortedList = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();

        return gson.toJson(sortedList);
    }

    @Override
    public String generateXMLRep(Predicate<Employee> filter) throws JAXBException {

        List<Employee> employeeList = new ArrayList<>(store.findBy(filter));

        List<Employee> employees = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();

        JAXBContext context = JAXBContext.newInstance(Employee.Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employee.Employees(employees), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}


