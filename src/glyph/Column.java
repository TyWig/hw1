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
        cursor.x = this.bounds.x;
        cursor.y = this.bounds.y + this.bounds.height;
        cursor.height = this.bounds.height;
        cursor.width = this.bounds.width;
        return cursor;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.width = this.bounds.width < childBounds.width ? childBounds.width : this.bounds.width;
        this.bounds.height += childBounds.height;
    }
}
