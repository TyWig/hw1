package command;

import java.util.Vector;

public class CommandHistory {
    private static CommandHistory instance = null;
    private Vector<Command> history;

    private CommandHistory() {
        history = new Vector<>();
    }

    public static CommandHistory getInstance() {
        if(instance == null)
            instance = new CommandHistory();
        return instance;
    }

    public boolean add(Command command) {
        return history.add(command);
    }

    public Command getLast() {
        return history.lastElement();
    }

    public boolean remove(Command command) {
        return history.remove(command);
    }
}
