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
    public Cursor getBounds() {
        this.cursor.x = this.x;
        this.cursor.y = this.y;
        for(Glyph child: this.children) {
            Cursor childBounds = child.getBounds();
            if(childBounds.height > this.cursor.height) { this.cursor.height = childBounds.height; }
            this.cursor.width += childBounds.width;
        }
        return this.cursor;
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }
}
