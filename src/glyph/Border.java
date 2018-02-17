package glyph;

import window.Window;

public class Border extends Embellishment {
    @Override
    public void draw(Window window) {

    }

    @Override
    public void compose() {

    }

    @Override
    public Cursor getBounds(Window window) {
        return null;
    }

    @Override
    public boolean intersects(int x, int y) {
        return false;
    }

    @Override
    public void insert(Glyph glyph, int position) {

    }

    @Override
    public void remove(Glyph glyph) {

    }

    @Override
    public Glyph child(int position) {
        return null;
    }

    @Override
    public void updateCursor(Cursor childBounds) {

    }
}
