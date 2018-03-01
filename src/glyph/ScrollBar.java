package glyph;

import window.Window;

//Decorator(175).ConcreteDecorator

public class ScrollBar extends Embellishment {
    private int width;

    public ScrollBar(Window window, Glyph glyph, int width) {
        super(window);
        this.width = width;
        this.bounds.width = width;
        this.children.addFirst(glyph);
        glyph.setParent(this);
        Glyph root = goToRoot();
        root.compose();
    }

    @Override
    public void draw(Window window) {
        for(Glyph glyph: this.children) {
            glyph.draw(window);
        }
        window.addScrollBar(this.bounds.x, this.bounds.y, this.width, this.bounds.height);
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor childBounds = this.children.getFirst().getBounds(window);
        Cursor bounds = new Cursor();
        bounds.height = this.bounds.height;
        bounds.width = this.width + childBounds.width;
        bounds.x = this.bounds.x;
        bounds.y = this.bounds.y;
        return bounds;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.width = childBounds.width;
        this.bounds.height = childBounds.height;
        this.bounds.x = childBounds.width;
        this.bounds.y = childBounds.y;
        this.children.getFirst().updateCursor(this.bounds);
    }
}
