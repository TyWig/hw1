package glyph;

import window.Window;
import strategy.*;

public class Composition extends CompositeGlyph {

    private Compositor compositor;

    public Composition(Window window) {
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
}
