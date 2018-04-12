package command;

import window.Window;

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
        System.out.println(this.getClass().toString() + " It worked");
    }

    @Override
    public void unexecute() {

    }

    @Override
    public Command clone() {
        return new UndoCommand(this.window);
    }
}
