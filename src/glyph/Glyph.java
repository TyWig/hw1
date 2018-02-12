package glyph;

import window.*;
import java.awt.Point;

public abstract class Glyph {
    protected int x;
    protected int y;
    protected Glyph parent;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public abstract void setParent(Glyph parent);
    public abstract void draw(Window window);
    public abstract void compose();
    public abstract Cursor getBounds();
    public abstract boolean intersects(Point point);
    public abstract void insert(Glyph glyph, int position);
    public abstract void remove(Glyph glyph);
    public abstract Glyph child(int position);
    public abstract Glyph getParent();
}
