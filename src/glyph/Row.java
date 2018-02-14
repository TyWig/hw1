package glyph;

import window.Window;

//Composite(165).Composite

public class Row extends CompositeGlyph {

    public Row(Window window) {
        super(window);
    }

    @Override
    public Cursor getBounds(Window window) {
        this.cursor.reset();
        this.cursor.x = this.x;
        this.cursor.y = this.y;
        for(Glyph child: this.children) {
            Cursor childBounds = child.getBounds(window);
            if(childBounds.height > this.cursor.height) {
                this.cursor.height += childBounds.height;
            }
            this.cursor.width += childBounds.width;
        }
        return this.cursor;
    }

    @Override
    public boolean intersects(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }
}
