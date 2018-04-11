package command;

import window.Window;

public abstract class Command {
    protected Window window;

    Command(Window window) {
        this.window = window;
    }

    public abstract void execute();
    public abstract void unexecute();
    public abstract Command clone();
}
