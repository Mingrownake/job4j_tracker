package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCollection;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");

    }

    @Test
    public void whenCannotFindBYKey() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Pes", "Barbos", "123456", "Moscow")
        );
        ArrayList<Person> persons = phones.find("Kot");
        assertThatCollection(persons).isEmpty();
    }
}