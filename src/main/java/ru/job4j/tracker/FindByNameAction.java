package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by Name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}

