package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = Integer.parseInt(input.askStr("Please select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Please enter item's name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Added a new item: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all Items");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("The storage has no items.");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int id = Integer.parseInt(input.askStr("Please enter item's id: "));
                String name = input.askStr("Please enter a new name: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("The item has been changed.");
                } else {
                    System.out.println("Error when changing the item.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                int id = Integer.parseInt(input.askStr("Please enter item's id: "));
                if (tracker.delete(id)) {
                    System.out.println("The item has been deleted.");
                } else {
                    System.out.println("Error when deleting the item.");
                }
            } else if (select == 4) {
                System.out.println("=== Look up by item's id ===");
                int id = Integer.parseInt(input.askStr("Please enter item's id: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Item" + " with id " + id + " is not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Look up by item's name ===");
                String name = input.askStr("Please enter item's name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Items" + " with name " + name + " are not found.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find item by name",
                "Exit program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}