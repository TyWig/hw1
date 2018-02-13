package glyph;

import window.Window;
import strategy.*;

public class Composition extends CompositeGlyph {

    private Compositor compositor;

    public Composition(Window window) {
        super();
        this.compositor = new SimpleCompositor(window);
        this.compositor.setComposition(this);
    }

    @Override
    public void compose() {
        this.compositor.compose();
    }

    @Override
    public Cursor getBounds() {
        return new Cursor();
    }

    @Override
    public void insert(Glyph glyph, int position) {
        super.insert(glyph, position);
        for(Glyph child: this.children){
            child.compose();
        }
        this.compose();
    }

    @Override
    public void remove(Glyph glyph) {
        super.remove(glyph);
        this.compose();
    }
}
