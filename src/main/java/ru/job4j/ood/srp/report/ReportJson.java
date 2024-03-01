package ru.job4j.ood.srp.report;

import com.google.gson.Gson;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReportJson implements Report {
    private final Store store;
    private Gson gson;

    public ReportJson(Store store,
                      Gson gson) {
        this.store = store;
        this.gson = gson;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employeeList = new ArrayList<>(store.findBy(filter));
        return gson.toJson(employeeList);
    }
}

