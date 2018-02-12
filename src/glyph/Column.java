package glyph;

import java.awt.Point;
import window.Window;

public class Column extends CompositeGlyph {

    public Column() {
        super();
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
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
    public void insert(Glyph glyph, int position) {
        super.insert(glyph, position);
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
