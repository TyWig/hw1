package glyph;

import window.Window;
import command.Command;

// FactoryMethod(107).Product
// AbstractFactory(87).AbstractProduct
// Command(233).Receiver
// ChainOfResponsibility(233).ConcreteHandler

public abstract class Button extends CompositeGlyph {
    protected String myColor;
    private Command command;

    public Button(Window window, Command command) {
        super(window);
        this.command = command;
    }

    public Button(Window window) {
        super(window);
    }

    @Override
    public Glyph find(int x, int y) {
        int x1 = this.bounds.x;
        int x2 = this.bounds.x + this.bounds.width;
        int y1 = this.bounds.y;
        int y2 = this.bounds.y + this.bounds.height;

        boolean isInX = (x >= x1 && x <= x2);
        boolean isInY = (y >= y1 && y <= y2);

        if(isInX && isInY) {
            return this;
        } else {
            return null;
        }
    }

    @Override
    public Command click() {
        return this.command;
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
