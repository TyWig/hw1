package glyph;

import window.Window;

import java.awt.Point;

public class Rectangle extends CompositeGlyph {

    private Glyph parent;

    public Rectangle (int width, int height) {
        super();
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    @Override
    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(this.x, this.y, this.width, this.height);
    }

    @Override
    public void compose() {
        System.out.println(this.x + " " + this.y);
    }

    @Override
    public Cursor getBounds() {
        Cursor bounds = new Cursor();
        bounds.x = this.x;
        bounds.y = this.y;
        bounds.height = this.height;
        bounds.width = this.width;
        return bounds;
    }

    @Override
    public boolean intersects(Point point) { 
        return false;
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

    @Override
    public Glyph getParent() {
        return parent;
    }
}
