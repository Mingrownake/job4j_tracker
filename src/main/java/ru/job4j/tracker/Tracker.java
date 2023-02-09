package ru.job4j.tracker;

import java.util.Arrays;

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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] addedAllItems = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item itemToAdd = items[index];
            if (itemToAdd != null) {
                addedAllItems[size] = itemToAdd;
                size++;
            }
        }
        return Arrays.copyOf(addedAllItems, size);
    }

    public Item[] findByName(String key) {
        Item[] addedItemsByName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item itemToAdd = items[index];
            if (itemToAdd != null) {
                if (key.equals(itemToAdd.getName())) {
                    addedItemsByName[size] = itemToAdd;
                    size++;
                }
            }
        }
        return Arrays.copyOf(addedItemsByName, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}