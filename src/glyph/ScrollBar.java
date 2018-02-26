package glyph;

import window.Window;

public class ScrollBar extends Embellishment {

    ScrollBar(Window window, Glyph glyph) {
        super(window);
        this.children.addFirst(glyph);
    }

    @Override
    public Cursor getBounds(Window window) {
        return null;
    }

    @Override
    public void updateCursor(Cursor childBounds) {

    }
}
