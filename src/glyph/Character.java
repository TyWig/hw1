package glyph;

import window.Window;
import java.awt.Point;

public class Character extends Glyph {
    private char myChar;

    public Character(char c) {
        super();
        this.x = 0;
        this.y = 0;
        this.myChar = c;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(this.myChar, this.x, this.y);
        this.height = window.charHeight(this.myChar);
        this.width = window.charWidth(this.myChar);
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
}
