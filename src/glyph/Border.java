package glyph;

import window.Window;

public class Border extends Embellishment {

    private int topMargin = 5;
    private int leftMargin = 5;
    private int rightMargin = 5;
    private int bottomMargin = 5;
    private int width = 1;

    public Border(Window window, Glyph glyph) {
        super(window);
        this.children.addFirst(glyph);
        glyph.setParent(this);
        Glyph root = goToRoot();
        root.compose();
        //this.updateCursor(glyph.getBounds(window));
    }

    @Override
    public void draw(Window window) {
        for(Glyph child: this.children){
            child.draw(window);
        }
        window.addBorder(this.bounds.x,this.bounds.y, this.bounds.width, this.bounds.height, this.width);
    }

    @Override
    public Cursor getBounds(Window window) {
        Cursor bounds = new Cursor();
        bounds.height = this.bounds.height;
        bounds.width = this.bounds.width;
        bounds.x = this.bounds.x + this.width;
        bounds.y = this.bounds.y + this.width;
        return bounds;
    }

    @Override
    public void updateCursor(Cursor childBounds) {
        this.bounds.width = childBounds.width > this.bounds.width ? childBounds.width : this.bounds.width;
        this.bounds.height = childBounds.height > this.bounds.height ? childBounds.height : this.bounds.height;
        this.bounds.x = childBounds.x;
    }
}
