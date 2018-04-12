package widget;

import command.Command;
import glyph.Button;
import glyph.Label;
import window.Window;

//FactoryMethod(107).ConcreteCreator
//AbstractFactory(87).ConcreteFactory

class RedFactory extends GUIFactory {
    private static RedFactory instance;

    private RedFactory() { }

    static GUIFactory instance() {
        if(instance == null)
            instance = new RedFactory();
        return instance;
    }

    @Override
    protected Button factoryCreateButton(Window window) {
        return new RedButton(window);
    }

    @Override
    public Button factoryCreateButton(Window window, Command command) {
        return new RedButton(window, command);
    }

    @Override
    public Label factoryCreateLabel(Window window) {
        return new RedLabel(window);
    }
}