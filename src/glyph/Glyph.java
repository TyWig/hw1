package glyph;

import command.Command;
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

    public Command click() {
        return null;
    }

    @Override
    public String toString()
    {
        return String.format("Type: %s\tX: %d\tY: %d\tWidth: %d\tHeight: %d\n", this.getClass().toString(), this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height );
    }


    public abstract Glyph find(int x, int y);
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
