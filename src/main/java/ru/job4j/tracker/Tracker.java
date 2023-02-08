package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] addedAllItems = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item itemToAdd = items[index];
            if (itemToAdd != null) {
                addedAllItems[index] = itemToAdd;
                size++;
            }
        }
        addedAllItems = Arrays.copyOf(addedAllItems, size);
        return addedAllItems;
    }

    public Item[] findByName(String key) {
        Item[] addedItemsByName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item itemToAdd = items[index];
            if (itemToAdd != null) {
                if (key.equals(itemToAdd.getName())) {
                    addedItemsByName[index] = itemToAdd;
                    size++;
                }
            }
        }
        addedItemsByName = Arrays.copyOf(addedItemsByName, size);
        return addedItemsByName;
    }
}