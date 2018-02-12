package glyph;

import window.Window;
import java.awt.Point;

public class Row extends CompositeGlyph {

    public Row() {
        super();
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
    }

    @Override
    public void setParent(Glyph parent) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public boolean intersects(Point point) {
        return false;
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
