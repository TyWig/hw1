package command;

import window.Window;

public class DecreaseFontSizeCommand extends Command {
    private int oldFontSize;
    private int currentFontSize;

    public DecreaseFontSizeCommand(Window window) {
        super(window);
//        this.currentFontSize = window.getFontSize();
    }

    @Override
    public void execute() {
        this.oldFontSize = this.currentFontSize;
        currentFontSize--;
        window.setFontSize(this.currentFontSize);
        System.out.println(this.getClass().toString() + " It worked");
    }

    @Override
    public void unexecute() {
        this.currentFontSize = this.oldFontSize;
        window.setFontSize(this.currentFontSize);
        window.repaint();
    }

    @Override
    public Command clone() {
        return new DecreaseFontSizeCommand(this.window);
    }
}
