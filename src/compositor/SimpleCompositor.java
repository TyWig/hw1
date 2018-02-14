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
        Cursor newBounds = composition.getBounds(this.window);
        int childIndex = 0;
        Glyph next = composition.child(childIndex);

        while(next != null) {
            Cursor childBounds = next.getBounds(this.window);
            next.intersects(newBounds.height,newBounds.width);

            Cursor testBounds = next.getBounds(this.window);
            next.compose();
//            newBounds.x +=  testBounds.x;
//            newBounds.y +=  testBounds.height;

            childIndex++;
            next = composition.child(childIndex);
            bounds = newBounds;
        }
    }
}
