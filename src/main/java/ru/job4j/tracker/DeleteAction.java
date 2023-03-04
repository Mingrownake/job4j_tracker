package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete an Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Please enter item's id: ");
        if (tracker.delete(id)) {
            System.out.println("The item has been deleted.");
        } else {
            System.out.println("Error when deleting the item.");
        }
        return true;
    }
}