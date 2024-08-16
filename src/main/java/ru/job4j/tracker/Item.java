package ru.job4j.tracker;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String name;

    private LocalDateTime created = LocalDateTime.now().withNano(0);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Item(String name, int id, LocalDateTime created) {
        this.name = name;
        this.id = id;
        this.created = created;
    }

}
