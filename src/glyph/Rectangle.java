package glyph;

import window.Window;

import java.util.Iterator;

//Composite(165).Leaf

public class Rectangle extends Glyph {

    public Rectangle (int width, int height) {
        this.bounds.width = width;
        this.bounds.height = height;
    }

    @Override
    public boolean find(int x, int y) {
        return false;
    }

    @Override
    public Iterator<Glyph> getIterator() {
        return null;
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
    }

    @Override
    public void compose() { }

    @Override
    public Cursor getBounds(Window window) {
        Cursor cursor = new Cursor();
        cursor.setBounds(this.bounds);
        return cursor;
    }

    @Override
    public void insert(Glyph glyph) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(Glyph[] glyphs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Glyph child(int position) {
        return null;
    }

    @Override
    public void updateCursor(Cursor childBounds) { }

}
