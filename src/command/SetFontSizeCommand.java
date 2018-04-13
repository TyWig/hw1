package command;

import window.Window;

// Command(233).ConcreteCommand
// Prototype(117).ConcretePrototype

public class SetFontSizeCommand extends Command {
    private int fontSize;
    private int oldFontSize;

    public SetFontSizeCommand(Window window, int fontSize) {
        super(window);
        this.fontSize = fontSize;
    }

    private SetFontSizeCommand(Window window, int fontSize, int oldFontSize) {
        this(window, fontSize);
        this.oldFontSize = oldFontSize;
    }

    @Override
    public boolean isUndoable() {
        return false;
    }

    @Override
    public void execute() {
        this.oldFontSize = this.window.getFontSize();
        this.window.setFontSize(this.fontSize);
        this.window.repaint();
    }

    @Override
    public void unexecute() {
        this.window.setFontSize(this.oldFontSize);
        this.window.repaint();
    }

    @Override
    public Command clone() {
        return new SetFontSizeCommand(this.window, this.fontSize, this.oldFontSize);
    }
}
