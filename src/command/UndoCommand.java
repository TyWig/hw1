package command;

import window.Window;

// Command(233).ConcreteCommand
// Prototype(117).ConcretePrototype

public class UndoCommand extends Command {

    public UndoCommand(Window window) {
        super(window);
    }

    @Override
    public boolean isUndoable() {
        return false;
    }

    @Override
    public void execute() {
        this.window.undoCommand();
    }

    @Override
    public void unexecute() {
        this.window.redoCommand();
    }

    @Override
    public Command clone() {
        return new UndoCommand(this.window);
    }
}
