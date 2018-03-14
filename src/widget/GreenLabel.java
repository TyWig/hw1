package widget;

import glyph.Label;
import window.Window;

//FactoryMethod(107).ConcreteProduct
//AbstractFactory(87).ConcreteProduct

class GreenLabel extends Label {
    GreenLabel(Window window) {
        super(window);
        this.myColor = "Green";
    }
}
