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
        cursor.x = this.bounds.x + this.bounds.width;
        cursor.y = this.bounds.y;
        cursor.height = this.bounds.height;
        cursor.width = this.bounds.width;
        return cursor;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.height = this.bounds.height < childBounds.height ? childBounds.height : this.bounds.height;
        this.bounds.width += childBounds.width;
    }
}
