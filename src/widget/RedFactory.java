package widget;

import glyph.Button;
import glyph.Label;
import window.Window;

class RedFactory extends GUIFactory {
    private static RedFactory instance;

    private RedFactory() { }

    static GUIFactory instance() {
        if(instance == null)
            instance = new RedFactory();
        return instance;
    }

    @Override
    public Button factoryCreateButton(Window window) {
        return new RedButton(window);
    }

    @Override
    public Label factoryCreateLabel(Window window) {
        return new RedLabel(window);
    }
}