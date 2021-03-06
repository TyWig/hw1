package glyph;

import window.Window;

//Decorator(175).Decorator

abstract class Embellishment extends CompositeGlyph {

    Embellishment(Window window) {
        super(window);
    }

    @Override
    public void intersects(int x, int y) {
        this.bounds.x = x;
        this.bounds.y = y;
        this.children.getFirst().intersects(x, y);
    }

    @Override
    public void insert(Glyph glyph) {
        this.children.getFirst().insert(glyph);
    }

    @Override
    public void remove(Glyph glyph) {
        this.children.getFirst().remove(glyph);
    }
}
