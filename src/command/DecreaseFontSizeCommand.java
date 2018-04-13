package command;

import window.Window;

// Command(233).ConcreteCommand
// Prototype(117).ConcretePrototype

public class DecreaseFontSizeCommand extends Command {
    private int oldFontSize;
    private int currentFontSize;

    public DecreaseFontSizeCommand(Window window) {
        super(window);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }

    private DecreaseFontSizeCommand(Window window, int oldFontSize, int currentFontSize) {
        this(window);
        this.oldFontSize = oldFontSize;
        this.currentFontSize = currentFontSize;
    }

    @Override
    public void execute() {
        this.currentFontSize = this.window.getFontSize();
        this.oldFontSize = this.currentFontSize;
        this.currentFontSize--;
        window.setFontSize(this.currentFontSize);
        window.repaint();
    }

    @Override
    public void unexecute() {
        this.currentFontSize = this.oldFontSize;
        window.setFontSize(this.currentFontSize);
        window.repaint();
    }

    @Override
    public Command clone() {
        return new DecreaseFontSizeCommand(this.window, this.oldFontSize, this.currentFontSize);
    }
}
