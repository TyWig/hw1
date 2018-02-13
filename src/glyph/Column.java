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
        this.cursor.x = this.x;
        this.cursor.y = this.y;
        for(Glyph child: this.children) {
            Cursor childBounds = child.getBounds();
            if(childBounds.width > this.cursor.width) { this.cursor.width = childBounds.width; }
            this.cursor.width += childBounds.width;
        }
        return this.cursor;
    }

    @Override
    public boolean intersects(Point point) {
        return false;
    }
}
