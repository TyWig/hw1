package glyph;

import window.*;
import java.awt.Point;

public abstract class Glyph {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Glyph parent;
    protected Cursor cursor;

    public Glyph() {
        this.cursor = new Cursor();
    }

    public void setParent(Glyph parent) {
        this.parent = parent;
    }
    public Glyph getParent() {
        return this.parent;
    }
    public abstract void draw(Window window);
    public abstract void compose();
    public abstract Cursor getBounds();
    public abstract boolean intersects(Point point);
    public abstract void insert(Glyph glyph, int position);
    public abstract void remove(Glyph glyph);
    public abstract Glyph child(int position);
}
