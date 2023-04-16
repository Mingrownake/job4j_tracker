package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: from 0 to " + (actions.size() - 1) + ".");
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new CreateAction(output),
                new EditAction(output),
                new ShowAllAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new DeleteAction(output),
                new ExitAppAction(output)
        ));
        new StartUI(output).init(input, tracker, actions);
    }
}