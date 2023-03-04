package ru.job4j.tracker;

public class ExitAppAction implements UserAction {
    @Override
    public String name() {
        return "Exit the App.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        return false;
    }
}
