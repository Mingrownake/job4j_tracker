package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
/* Для отдела программистов потребовался отчет в формате CSV
 Отчет нужно изобразить в данном формате с помощью строк.  */

public class ReportForDevDept implements Report {

    private final Store store;

    private JAXBContext context = JAXBContext.newInstance(Employee.class);

    private final DateTimeParser<Calendar> dateTimeParser;

    private Gson gson = new GsonBuilder().create();

    public ReportForDevDept(Store store,
                            DateTimeParser<Calendar> dateTimeParser) throws JAXBException {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    public ReportForDevDept(Store store,
                            DateTimeParser<Calendar> dateTimeParser,
                            Gson gson) throws JAXBException {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = gson;
    }

    public ReportForDevDept(Store store,
                            DateTimeParser<Calendar> dateTimeParser,
                            JAXBContext context) throws JAXBException {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String delimiter = ";";
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());

        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(delimiter)
                    .append(dateTimeParser.parse(employee.getHired())).append(delimiter)
                    .append(dateTimeParser.parse(employee.getFired())).append(delimiter)
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    @Override
    public String generateJsonRep(Predicate<Employee> filter) {

        List<Employee> employeeList = new ArrayList<>(store.findBy(filter));

        return gson.toJson(employeeList);
    }

    @Override
    public String generateXMLRep(Predicate<Employee> filter) throws JAXBException {

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

