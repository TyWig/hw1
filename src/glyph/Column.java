package glyph;

import window.Window;

//Composite(165).Composite

public class Column extends CompositeGlyph {

    public Column(Window window) {
        super(window);
    }

    @Override
    public Cursor getBounds(Window window) {
        this.cursor.reset();
        this.cursor.x = this.x;
        this.cursor.y = this.y;
        for(Glyph child: this.children) {
            Cursor childBounds = child.getBounds(window);
            if(childBounds.width > this.cursor.width) {
                this.cursor.width += childBounds.width;
            }
            this.cursor.height += childBounds.height;
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
