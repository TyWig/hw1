package glyph;

import window.Window;
import java.awt.Point;
import java.util.Vector;
import strategy.*;

public class Composition extends CompositeGlyph {

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
    public void compose() {

    }

    @Override
    public Cursor getBounds() {
        return new Cursor();
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }

    @Override
    public void insert(Glyph glyph, int position) {

    }

    @Override
    public void remove(Glyph glyph) {

    }

    @Override
    public Glyph child(int position) {

        return null;
    }
    @Override
    public Glyph getParent() {

        return null;
    }
}
