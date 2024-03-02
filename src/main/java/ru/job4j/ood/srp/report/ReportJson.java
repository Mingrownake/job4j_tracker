package ru.job4j.ood.srp.report;

import com.google.gson.Gson;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReportJson implements Report {
    private final Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new Gson().newBuilder().create();
        List<Employee> employeeList = new ArrayList<>(store.findBy(filter));
        return gson.toJson(employeeList);
    }
}

