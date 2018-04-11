package glyph;

import window.Window;
import command.Command;

//FactoryMethod(107).Product
//AbstractFactory(87).AbstractProduct

public abstract class Button extends CompositeGlyph {
    protected String myColor;
    protected Command command;

    public Button(Window window) {
        super(window);
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public boolean find(int x, int y) {
        return false;
    }

    @Override
    public void draw(Window window) {
        window.drawButton(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height, this.myColor);
        for(Glyph child: this.children) {
            child.draw(window);
        }
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor cursor = new Cursor();
        cursor.x = this.bounds.x + this.bounds.width;
        cursor.y = this.bounds.y;
        cursor.height = this.bounds.height;
        cursor.width = this.bounds.width;
        return cursor;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.height = this.bounds.height < childBounds.height ? childBounds.height : this.bounds.height;
        this.bounds.width += childBounds.width;
    }
}
