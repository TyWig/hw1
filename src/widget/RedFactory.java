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
    public Button createButton(Window window) {
        return new RedButton(window);
    }

    @Override
    public Label createLabel(Window window) {
        return new RedLabel(window);
    }
}