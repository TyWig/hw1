package compositor;

import glyph.Composition;
import glyph.Cursor;
import glyph.Glyph;
import window.Window;

//Strategy(315).ConcreteStrategy

public class SimpleCompositor implements Compositor {

    private Window window;
    private Composition composition;

    public SimpleCompositor(Window window) {
        this.window = window;
    }

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void compose() {
        Cursor newBounds = composition.getBounds(this.window);
        int childIndex = 0;
        Glyph next = composition.child(childIndex);

        while(next != null) {
            next.intersects(newBounds.x, newBounds.y);
            next.compose();

            Cursor childBounds = next.getBounds(this.window);
            this.composition.updateCursor(childBounds);
            newBounds = composition.getBounds(this.window);

            childIndex++;
            next = composition.child(childIndex);
        }
    }
}
