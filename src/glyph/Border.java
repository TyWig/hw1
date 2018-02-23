package glyph;

import window.Window;

public class Border extends Embellishment {

    public Border(Window window, Glyph glyph) {
        super(window);
        this.children.add(glyph);
        glyph.setParent(this);
    }

    @Override
    public void draw(Window window) {
        for(Glyph child: this.children){
            child.draw(window);
        }
        window.addBorder(0,0, this.bounds.width, this.bounds.height, 1);
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor bounds = new Cursor();
        bounds.height = this.bounds.height;
        bounds.width = this.bounds.width;
        bounds.x = this.bounds.x;
        bounds.y = this.bounds.y;
        return bounds;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.width += childBounds.width;
        this.bounds.height += childBounds.height;
    }
}
