package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.store.Store;
import ru.job4j.ood.srp.model.Employee;

import java.util.*;
import java.util.function.Predicate;

public class ReportForHRDept implements Report {
    private final Store store;

    public ReportForHRDept(Store store) {
        this.store = store;
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
}
