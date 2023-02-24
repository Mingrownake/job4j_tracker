package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Please select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter item's name: ");
                String name = scanner.nextLine();
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
                System.out.print("Please enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Please enter a new name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("The item has been changed.");
                } else {
                    System.out.println("Error when changing the item.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Please enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("The item has been deleted.");
                } else {
                    System.out.println("Error when deleting the item.");
                }
            } else if (select == 4) {
                System.out.println("Look up by item's id.");
                System.out.print("Please enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Item" + " with id " + id + " is not found.");
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}