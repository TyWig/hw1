package glyph;

import window.Window;
import compositor.*;

//Composite(165).Component

public abstract class Composition extends Glyph {

    private Compositor compositor;

    Composition(Window window) {
        this.compositor = new SimpleCompositor(window);
        this.compositor.setComposition(this);
    }

    @Override
    public void compose() {
        this.bounds.reset();
        this.compositor.compose();
    }

    public void updateBounds(Cursor cursor) {
        this.bounds.setBounds(cursor);
    }
}
