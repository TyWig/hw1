package glyph;

import window.Window;

import java.awt.Point;

public class Rectangle extends CompositeGlyph {

    private int width;
    private int height;
    private Glyph parent;

    public Rectangle (int width, int height) {
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
    public Rectangle getBounds() {
        return this;
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
