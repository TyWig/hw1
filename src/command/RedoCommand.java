package command;

import window.Window;

// Command(233).ConcreteCommand
// Prototype(117).ConcretePrototype

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
        window.undoCommand();
    }

    @Override
    public Command clone() {
        return new RedoCommand(this.window);
    }
}
