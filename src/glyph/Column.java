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
    public void compose() {

    }

    @Override
    public Cursor getBounds() {
        Cursor bounds = new Cursor();
        bounds.x = this.x;
        bounds.y = this.y;
        for(Glyph child: this.children) {
            Cursor childBounds = child.getBounds();
            if(childBounds.width > bounds.width) { bounds.width = childBounds.width; }
            bounds.width += childBounds.width;
        }
        return bounds;
    }

    @Override
    public boolean intersects(Point point) {

        return false;
    }
}
