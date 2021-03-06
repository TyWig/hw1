package glyph;

import visitor.GlyphVisitor;
import window.Window;

// Composite(165).Leaf
// Visitor(331).ConcreteElement

public class Character extends Glyph {
    private char myChar;

    public Character(char c) {
        this.myChar = c;
    }


    public char getChar() {
        return myChar;
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
    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Glyph find(int x, int y) {
        return null;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(this.myChar, this.bounds.x, this.bounds.y);
    }

    @Override
    public void compose() { }

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
    public void updateCursor(Cursor childBounds) { }
}
