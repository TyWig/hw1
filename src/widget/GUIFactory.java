package widget;

import command.Command;
import glyph.Button;
import glyph.Label;
import window.Window;

//AbstractFactory(87).AbstractFactory
//FactoryMethod(107).Creator
//Singleton(127).Singleton

public abstract class GUIFactory {
    private static GUIFactory instance;

    public static GUIFactory getInstance() {
        if(instance == null)
            instance = initializeInstance();
        return instance;
    }

    private static GUIFactory initializeInstance() {
        String s = System.getenv("LexiWidget");
        if(s == null)
            return RedFactory.instance();
        switch (s) {
            case "Red": return RedFactory.instance();
            case "Green" : return GreenFactory.instance();
            default: return RedFactory.instance();
        }
    }
    protected abstract Button factoryCreateButton(Window window, Command command);
    protected abstract Button factoryCreateButton(Window window);
    protected abstract Label factoryCreateLabel(Window window);

    public final Button createButton(Window window, Command command) {
        return factoryCreateButton(window, command);
    }

    public final Button createButton(Window window) {
        return factoryCreateButton(window);
    }

    public final Label createLabel(Window window) {
        return factoryCreateLabel(window);
    }
}
