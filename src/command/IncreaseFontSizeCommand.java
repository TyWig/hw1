package command;

import window.Window;

public class IncreaseFontSizeCommand extends Command {
    private int oldFontSize;
    private int currentFontSize;

    public IncreaseFontSizeCommand(Window window) {
        super(window);

    }

    @Override
    public void execute() {
        this.oldFontSize = this.currentFontSize;
        this.currentFontSize++;
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
        return new IncreaseFontSizeCommand(this.window);
    }
}
