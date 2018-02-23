package glyph;

import window.Window;

public class ScrollBar extends Embellishment {

    ScrollBar(Window window) {
        super(window);
    }

    @Override
    public Cursor getBounds(Window window) {
        return null;
    }

    @Override
    public void updateCursor(Cursor childBounds) {

    }
}
