package widget;

import glyph.Button;
import glyph.Label;
import window.Window;

class GreenFactory extends GUIFactory {
    private static GreenFactory instance;

    private GreenFactory(){ }

    static GUIFactory instance() {
        if(instance == null)
            instance = new GreenFactory();
        return instance;
    }

    @Override
    public Button factoryCreateButton(Window window) {
        return new GreenButton(window);
    }

    @Override
    public Label factoryCreateLabel(Window window) {
        return new GreenLabel(window);
    }
}
