package glyph;

import window.*;
import java.awt.Point;

public abstract class Glyph {
    protected int x;
    protected int y;

    public abstract void setParent(Glyph parent);
    public abstract void draw(Window window);
    abstract Rectangle getBounds();
    abstract boolean intersects(Point point);
    abstract void insert(Glyph glyph, int position);
    abstract void remove(Glyph glyph);
    abstract Glyph child(int position);
    abstract Glyph getParent();
}
