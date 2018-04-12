package command;

import window.Window;

public class IncreaseFontSizeCommand extends Command {
    private int oldFontSize;
    private int currentFontSize;

    public IncreaseFontSizeCommand(Window window) {
        super(window);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }

    private IncreaseFontSizeCommand(Window window, int oldFontSize, int currentFontSize) {
        super(window);
        this.oldFontSize = oldFontSize;
        this.currentFontSize = currentFontSize;
    }

    @Override
    public void execute() {
        this.currentFontSize = window.getFontSize();
        this.oldFontSize = this.currentFontSize;
        this.currentFontSize++;
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
        return new IncreaseFontSizeCommand(this.window, this.oldFontSize, this.currentFontSize);
    }
}
