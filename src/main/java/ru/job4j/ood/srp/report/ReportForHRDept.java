package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.store.Store;
import ru.job4j.ood.srp.model.Employee;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;
import java.util.function.Predicate;

public class ReportForHRDept implements Report {
    private final Store store;

    private Gson gson = new GsonBuilder().create();

    public ReportForHRDept(Store store) {
        this.store = store;
    }

    public ReportForHRDept(Store store, Gson gson) {
        this.store = store;
        this.gson = gson;
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
}

