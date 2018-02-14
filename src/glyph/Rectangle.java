package glyph;

import window.Window;

//Composite(165).Leaf

public class Rectangle extends Glyph {

    public Rectangle (int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(this.x, this.y, this.width, this.height);
    }

    @Override
    public void compose() {

    }

    @Override
    public Cursor getBounds(Window window) {
        this.cursor.width = this.width;
        this.cursor.height = this.height;
        this.cursor.y = this.y;
        this.cursor.x = this.x;
        return this.cursor;
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
