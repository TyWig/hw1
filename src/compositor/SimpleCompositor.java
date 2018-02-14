package compositor;

import glyph.Composition;
import glyph.Cursor;
import glyph.Glyph;
import window.Window;

//Strategy(315).ConcreteStrategy

public class SimpleCompositor implements Compositor {

    private Window window;
    private Composition composition;
    private Cursor bounds;

    public SimpleCompositor(Window window) {
        this.window = window;
        this.bounds = new Cursor();
    }

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void compose() {
        //TODO: fix this
        bounds = composition.getBounds(this.window);
        int childIndex = 0;
        Glyph next = composition.child(childIndex);

        while(next != null) {
            Cursor childBounds = next.getBounds(this.window);

            next.intersects(bounds.x,bounds.y);
            next.compose();

            bounds.x +=  childBounds.width;
            bounds.y +=  childBounds.height;

            childIndex++;
            next = composition.child(childIndex);
        }
    }
}
