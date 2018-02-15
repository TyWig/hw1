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
        this.width = 0;
        this.height = 0;
        this.compositor.compose();
    }

    public void updateBounds(Cursor cursor)
    {
        this.cursor = cursor;
    }
}
