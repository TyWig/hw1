package command;

import window.Window;

public class RedoCommand extends Command {

    public RedoCommand(Window window) {
        super(window);
    }

    @Override
    public boolean isUndoable() {
        return true;
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
        return new RedoCommand(this.window);
    }
}
