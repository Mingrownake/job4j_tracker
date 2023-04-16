package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    /* private final Item[] items = new Item[100]; */
    ArrayList<Item> items = new ArrayList<>(100);
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
      /*  items[size++] = item; */
        items.add(size++, item);
        return item;
    }

    public Item findById(int id) {
            return items.isEmpty() ? null : items.get(indexOf(id));
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> res = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (key.equals(item.getName())) {
                res.add(item);
            }
        }
        return res;
    }

    private int indexOf(int id) {
        int rsl = -1;
        if (!items.isEmpty()) {
            for (int index = 0; index < size; index++) {
                if (items.get(index).getId() == id) {
                    rsl = index;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
            item.setId(id);
            items.add(index, item);

        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}