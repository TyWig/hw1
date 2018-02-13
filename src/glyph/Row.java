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
    public void compose() {

    }

    @Override
    public Cursor getBounds() {
        Cursor bounds = new Cursor();
        bounds.x = this.x;
        bounds.y = this.y;
        for(Glyph child: this.children) {
            Cursor childBounds = child.getBounds();
            if(childBounds.height > bounds.height) { bounds.height = childBounds.height; }
            bounds.width += childBounds.width;
        }
        return bounds;
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }

    @Override
    public void remove(Glyph glyph) {
        this.children.remove(glyph);
    }

    @Override
    public Glyph child(int position) {
        return this.children.remove(position);
    }
}
