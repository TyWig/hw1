package command;

import window.Window;

public class RedoCommand extends Command {

    public RedoCommand(Window window) {
        super(window);
    }

    @Override
    public boolean isUndoable() {
        return false;
    }

    @Override
    public void execute() {
        window.redoCommand();
    }

    @Override
    public void unexecute() {
        window.redoCommand();
    }

    @Override
    public Command clone() {
        return new RedoCommand(this.window);
    }
}
