package glyph;

import window.Window;
import java.awt.Point;
import java.util.Vector;
import strategy.*;

public class Composition extends Glyph {

    private Vector<Glyph> children;
    private Compositor compositor;

    public Composition() {
        this.children = new Vector<>();
    }

    @Override
    public void setParent(Glyph parent) {

    }

    @Override
    public void draw(Window window) {

    }

    @Override
    Rectangle getBounds() {
        return null;
    }

    @Override
    boolean intersects(Point point) {
        return false;
    }

    @Override
    void insert(Glyph glyph, int position) {

    }

    @Override
    void remove(Glyph glyph) {

    }

    @Override
    Glyph child(int position) {
        return null;
    }

    @Override
    Glyph getParent() {
        return null;
    }
}
