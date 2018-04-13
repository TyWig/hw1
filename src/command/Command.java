package command;

import window.Window;

// Command(233).Command
// Prototype(117).Prototype

public abstract class Command {
    protected Window window;

    Command(Window window) {
        this.window = window;
    }

    public abstract boolean isUndoable();
    public abstract void execute();
    public abstract void unexecute();
    public abstract Command clone();
}
