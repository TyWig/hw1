package glyph;

import window.Window;

//Composite(165).Composite

public class Row extends CompositeGlyph {

    public Row(Window window) {
        super(window);
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor cursor = new Cursor();
        cursor.x = this.x + this.width;
        cursor.y = this.y;
        cursor.height = this.height;
        cursor.width = this.width;
        return cursor;
    }

    @Override
    public boolean intersects(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.height = this.height < childBounds.height ? childBounds.height : this.height;
        this.width += childBounds.width;
    }
}
