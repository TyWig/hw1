package glyph;

import window.*;

//Composite(165).Component

public abstract class Glyph {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    Glyph parent;
    Cursor cursor;

    public Glyph() {
        this.cursor = new Cursor();
    }

    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    public Glyph getParent() {
        return this.parent;
    }

    Glyph goToRoot() {
        Glyph last = this;
        Glyph next = this.parent;
        while(next != null){
            last = next;
            next = next.getParent();
        }
        return last;
    }
    public abstract void draw(Window window);
    public abstract void compose();
    public abstract Cursor getBounds(Window window);
    public abstract boolean intersects(int x, int y);
    public abstract void insert(Glyph glyph, int position);
    public abstract void remove(Glyph glyph);
    public abstract Glyph child(int position);
}
