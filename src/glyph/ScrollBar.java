package glyph;

import window.Window;

public class ScrollBar extends Embellishment {
    private int width;

    public ScrollBar(Window window, Glyph glyph, int width) {
        super(window);
        this.width = width;
        this.children.addFirst(glyph);
        this.updateCursor(glyph.getBounds(window));
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
        return null;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.width = childBounds.width;
        this.bounds.height = childBounds.height;
        this.bounds.x = this.bounds.width - this.width;
        this.bounds.y = childBounds.y;
    }
}
