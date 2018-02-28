package glyph;

import window.Window;

//Decorator(175).ConcreteDecorator

public class Border extends Embellishment {

    private int borderWidth = 1;

    public Border(Window window, Glyph glyph) {
        super(window);
        this.children.addFirst(glyph);
        glyph.setParent(this);
        Glyph root = goToRoot();
        root.compose();
    }

    @Override
    public void draw(Window window) {
        for(Glyph child: this.children){
            child.draw(window);
        }
        window.addBorder(this.bounds.x,this.bounds.y, this.bounds.x + this.bounds.width + this.borderWidth, this.bounds.y + this.bounds.height + this.borderWidth, this.borderWidth);
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor bounds = new Cursor();
        bounds.height = this.bounds.height;
        bounds.width = this.bounds.width;
        bounds.x = this.bounds.x + this.borderWidth;
        bounds.y = this.bounds.y + this.borderWidth;
        return bounds;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.children.getFirst().updateCursor(childBounds);
        this.bounds.width += (childBounds.width > this.bounds.width ? childBounds.width : this.bounds.width);
        this.bounds.height += (childBounds.height > this.bounds.height ? childBounds.height : this.bounds.height);
    }
}
