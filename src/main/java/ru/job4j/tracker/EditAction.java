package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Please enter item's id: ");
        String name = input.askStr("Please enter a new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("The item has been changed.");
        } else {
            System.out.println("Error when changing the item.");
        }
        return true;
    }
}