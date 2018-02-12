package glyph;

import java.awt.Point;
import window.Window;

import java.util.Iterator;
import java.util.Vector;

public abstract class CompositeGlyph extends Glyph {

    private Vector<Glyph> children;
    private Glyph parent;
    private Rectangle bounds;

    public CompositeGlyph() {
        this.children = new Vector<>();
    }

    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Iterator<Glyph> createIterator() {
        return children.listIterator();
    }

    @Override
    public void draw(Window window) {
        Iterator<Glyph> it = createIterator();
        System.out.println("drawing: ");
        for(Glyph child : children){
            child.draw(window);
        }
//        while(it.hasNext()){
//            it.next().draw(window);
//        }
    }

    @Override
    public Rectangle getBounds() {
        return this.bounds;
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }

    @Override
    public void insert(Glyph glyph, int position) {
        children.add(position, glyph);
    }

    @Override
    public void remove(Glyph glyph) {
        children.remove(glyph);
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
