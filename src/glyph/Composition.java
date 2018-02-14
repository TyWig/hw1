package glyph;

import window.Window;
import compositor.*;

//Composite(165).Component

public abstract class Composition extends Glyph {

    private Compositor compositor;

    Composition(Window window) {
        super();
        this.compositor = new SimpleCompositor(window);
        this.compositor.setComposition(this);
    }

    @Override
    public void compose() {
        this.compositor.compose();
    }
}
