package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
/* Для отдела программистов потребовался отчет в формате CSV
 Отчет нужно изобразить в данном формате с помощью строк.  */

public class ReportForDevDept implements Report {

    private final Store store;

    private final DateTimeParser<Calendar> dateTimeParser;

    private Gson gson = new GsonBuilder().create();

    public ReportForDevDept(Store store,
                            DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    public ReportForDevDept(Store store,
                            DateTimeParser<Calendar> dateTimeParser,
                            Gson gson) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = gson;
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
}
