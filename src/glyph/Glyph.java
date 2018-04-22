package glyph;

import command.Command;
import visitor.GlyphVisitor;
import window.*;
import iterator.Iterator;
import iterator.NullIterator;

// Composite(165).Component
// Decorator(175).Component
// ChainOfResponsibility(233).Handler
// Visitor(331).Element
// Visitor(331).ObjectStructure
// Iterator(257).Aggregate
// Visitor(331).Element
// Visitor(331).ObjectStructure
// FactoryMethod(107).Creator

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

    public Iterator createIterator() {
        return new NullIterator();
    }

    @Override
    public String toString()
    {
        return String.format("Type: %s\tX: %d\tY: %d\tWidth: %d\tHeight: %d\n", this.getClass().toString(), this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height );
    }

    public void accept(GlyphVisitor visitor) { }
    public abstract Glyph find(int x, int y);
    public abstract void draw(Window window);
    public abstract void compose();
    public abstract Cursor getBounds(Window window);
    public abstract void insert(Glyph glyph);
    public abstract void insert(Glyph[] glyphs);
    public abstract void remove(Glyph glyph);
    public abstract void updateCursor(Cursor childBounds);
}
