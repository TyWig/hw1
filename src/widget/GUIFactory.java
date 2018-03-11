package widget;

import glyph.Button;
import glyph.Label;
import window.Window;

public abstract class GUIFactory {
    public static GUIFactory getInstance() {
        String s = System.getenv("LexiWidget");
        if(s == null)
            return RedFactory.instance();
        switch (s) {
            case "Red": return RedFactory.instance();
            case "Green" : return GreenFactory.instance();
            default: return RedFactory.instance();
        }
    }

    
    public abstract Button createButton(Window window);
    public abstract Label createLabel(Window window);
}
