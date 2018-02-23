package glyph;

import window.Window;

//Composite(165).Leaf

public class Character extends Glyph {
    private char myChar;

    public Character(char c) {
        this.myChar = c;
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor bounds = new Cursor();
        bounds.width = window.charWidth(this.myChar);
        bounds.height = window.charHeight(this.myChar);
        bounds.x = this.bounds.x;
        bounds.y = this.bounds.y;
        this.bounds.width = bounds.width;
        this.bounds.height = bounds.height;
        return bounds;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(this.myChar, this.bounds.x, this.bounds.y);
    }

    @Override
    public void compose() { }

    @Override
    public void insert(Glyph glyph, int position) {
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
