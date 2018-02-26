package glyph;

import window.Window;

import javax.xml.bind.annotation.XmlElementDecl;

public class Border extends Embellishment {

    private int topMargin = 2;
    private int leftMargin = 2;
    private int rightMargin = 2;
    private int bottomMargin = 2;

    public Border(Window window, Glyph glyph) {
        super(window);
        this.children.addFirst(glyph);
        glyph.setParent(this);
        this.updateCursor(glyph.getBounds(window));
    }

    @Override
    public void draw(Window window) {
        for(Glyph child: this.children){
            child.draw(window);
        }
        window.addBorder(this.bounds.x,this.bounds.y, this.bounds.width + this.rightMargin, this.bounds.height + this.bottomMargin, 1);
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor bounds = new Cursor();
        bounds.height = this.bounds.height;
        bounds.width = this.bounds.width;
        bounds.x = this.bounds.x + this.topMargin;
        bounds.y = this.bounds.y + this.leftMargin;
        return bounds;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.width = childBounds.width > this.bounds.width ? childBounds.width : this.bounds.width;
        this.bounds.height = childBounds.height > this.bounds.height ? childBounds.height : this.bounds.height;
    }
}
