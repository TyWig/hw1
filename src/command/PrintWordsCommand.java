package command;

import window.Window;

public class PrintWordsCommand extends Command {

    public PrintWordsCommand(Window window) {
        super(window);
    }

    @Override
    public boolean isUndoable() {
        return false;
    }

    @Override
    public void execute() {
        System.out.println("fuck");
    }

    @Override
    public void unexecute() { }

    @Override
    public Command clone() {
        return this;
    }
}
