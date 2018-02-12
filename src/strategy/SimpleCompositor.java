package strategy;

import glyph.Composition;
import window.Window;


// every composition should have a reference to a compositor
public class SimpleCompositor implements Compositor {

    private Window window;
    private Composition composition;
    private Bounds bounds;

    public SimpleCompositor(Window window) {
        this.window = window;
    }

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void compose() {

    }

    private class Bounds
    {
        private int x;
        private int y;
        private int height;
        private int width;
    }
}
