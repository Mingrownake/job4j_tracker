package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);

    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
            for (Person record : persons) {
                if (record.getPhone().contains(key) || record.getAddress().contains(key)
                    || record.getName().contains(key) || record.getSurname().contains(key)) {
                    result.add(record);
                }
            }
        return result;
    }
}
