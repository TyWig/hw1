package command;

import window.Window;

public class SetFontSizeCommand extends Command {
    private int fontSize;

    public SetFontSizeCommand(Window window, int fontSize) {
        super(window);
        this.fontSize = fontSize;
    }

    @Override
    public boolean isUndoable() {
        return false;
    }

    @Override
    public void execute() {
        this.window.setFontSize(this.fontSize);
        this.window.repaint();
    }

    @Override
    public void unexecute() {

    }

    @Override
    public Command clone() {
        return new SetFontSizeCommand(this.window, this.fontSize);
    }
}
