package glyph;

import window.Window;

//Composite(165).Composite

public class Column extends CompositeGlyph {

    public Column(Window window) {
        super(window);
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor cursor = new Cursor();
        cursor.x = this.x;
        cursor.y = this.y + this.height;
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
        this.width = this.width < childBounds.width ? childBounds.width : this.width;
        this.height += childBounds.height;
    }
}
