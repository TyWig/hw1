package glyph;

import window.Window;

public class ScrollBar extends Embellishment {

    public ScrollBar(Window window, Glyph glyph) {
        super(window);
        this.children.addFirst(glyph);
        this.updateCursor(glyph.getBounds(window));
    }

    @Override
    public void draw(Window window) {
        for(Glyph glyph: this.children) {
            glyph.draw(window);
        }
        window.addScrollBar(this.bounds.width,this.bounds.y,10,this.bounds.height);
    }

    @Override
    public Cursor getBounds(Window window) {
        return null;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.width = childBounds.width > this.bounds.width ? childBounds.width : this.bounds.width;
        this.bounds.height = childBounds.height > this.bounds.height ? childBounds.height : this.bounds.height;
    }
}
