package command;

import java.util.Vector;

// Singleton(127)

public class CommandHistory {
    private static CommandHistory instance = null;
    private Vector<Command> history;
    private int present;

    private CommandHistory() {
        history = new Vector<>();
    }

    public static CommandHistory getInstance() {
        if(instance == null)
            instance = new CommandHistory();
        return instance;
    }

    public void add(Command command) {
        if(present < history.size()) {

          this.clearUndoneCommands();
        }
        history.add(command);
        present = history.size();
    }

    public void undo() {
        if(!history.isEmpty() && present - 1 >= 0) {
            Command command = history.elementAt(present-1);
            command.unexecute();
            present--;
        }
    }

    public void redo() {
        if(present < history.size() && present >= 0) {
            Command command = history.elementAt(present);
            command.execute();
            present++;
        }
    }

    private void clearUndoneCommands() {
        for (int i = history.size() - 1; i > present - 1; i--) {
            history.remove(i);
        }
    }
}
