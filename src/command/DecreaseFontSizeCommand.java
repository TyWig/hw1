package command;

import window.Window;

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
        super(window);
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
//        System.out.println(this.getClass().toString() + " It worked");
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
