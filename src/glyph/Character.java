package glyph;

import window.Window;

//Composite(165).Leaf

public class Character extends Glyph {
    private char myChar;

    public Character(char c) {
        super();
        this.x = 0;
        this.y = 0;
        this.myChar = c;
    }

    @Override
    public Cursor getBounds(Window window) {
        this.cursor.reset();
        this.width = window.charWidth(this.myChar);
        this.height = window.charHeight(this.myChar);
        this.cursor.height = this.height;
        this.cursor.width = this.width;
        this.cursor.x = this.x;
        this.cursor.y = this.y;
        return this.cursor;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(this.myChar, this.x, this.y);
    }

    @Override
    public void compose() {
//        System.out.println(this.myChar);
    }

    @Override
    public boolean intersects(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
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
