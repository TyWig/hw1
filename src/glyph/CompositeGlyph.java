package glyph;

import java.awt.Point;
import window.Window;

import java.util.Iterator;
import java.util.Vector;

public abstract class CompositeGlyph extends Glyph {
    protected Vector<Glyph> children;

    public CompositeGlyph() {
        super();
        this.children = new Vector<>();
    }

    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    public Iterator<Glyph> createIterator() {
        return children.listIterator();
    }

    @Override
    public void compose(){
        for(Glyph child: this.children) {
            child.compose();
        }
    }

    @Override
    public void draw(Window window) {
        for(Glyph child: this.children) {
            child.draw(window);
        }
    }

    @Override
    public Cursor getBounds() {
        return this.cursor;
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }

    @Override
    public void insert(Glyph glyph, int position) {
        children.add(position, glyph);
        glyph.setParent(this);
    }

    @Override
    public void remove(Glyph glyph) {
        children.remove(glyph);
        glyph.setParent(null);
    }

    @Override
    public Glyph child(int position) {
        return children.get(position);
    }

    @Override
    public Glyph getParent() {
        return parent;
    }
}
