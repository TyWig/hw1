package glyph;

import window.Window;
import java.awt.Point;

public class Character extends Glyph {

    private Glyph parent;
    private char myChar;

    public Character(char c) {
        this.x = 0;
        this.y = 0;
        this.myChar = c;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(this.myChar, this.x, this.y);
    }

    @Override
    public void compose() {

    }

    @Override
    public Cursor getBounds() {
        return new Cursor();
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }

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
        throw new UnsupportedOperationException();
    }

    @Override
    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    @Override
    public Glyph getParent() {
        return this.parent;
    }
}
