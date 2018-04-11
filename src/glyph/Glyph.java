package glyph;

import window.*;
import java.util.Iterator;

//Composite(165).Component
//Decorator(175).Component

public abstract class Glyph {
    private Glyph parent;
    Cursor bounds = new Cursor();

    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    private Glyph getParent() {
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

    public void intersects(int x, int y) {
        this.bounds.x = x;
        this.bounds.y = y;
    }

    @Override
    public String toString()
    {
        return String.format("Type: %s\tX: %d\tY: %d\tWidth: %d\tHeight: %d\n", this.getClass().toString(), this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height );
    }

    public boolean find(int x, int y) {
        int x1 = this.bounds.x;
        int x2 = this.bounds.x + this.bounds.width;
        int y1 = this.bounds.y;
        int y2 = this.bounds.y + this.bounds.height;

        boolean isInX = (x >= x1 && x <= x2);
        boolean isInY = (y >= y1 && y <= y2);

        return isInX && isInY;
    }

    public abstract Iterator<Glyph> getIterator();
    public abstract void draw(Window window);
    public abstract void compose();
    public abstract Cursor getBounds(Window window);
    public abstract void insert(Glyph glyph);
    public abstract void insert(Glyph[] glyphs);
    public abstract void remove(Glyph glyph);
    public abstract Glyph child(int position);
    public abstract void updateCursor(Cursor childBounds);
}
