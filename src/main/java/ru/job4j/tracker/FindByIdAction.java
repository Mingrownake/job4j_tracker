package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by Id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Look up by item's id ===");
        int id = input.askInt("Please enter item's id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item" + " with id " + id + " is not found.");
        }
        return true;
    }
}
