package widget;

import glyph.Label;
import window.Window;

//FactoryMethod(107).ConcreteProduct
//AbstractFactory(87).ConcreteProduct

class RedLabel extends Label {

    RedLabel(Window window) {
        super(window);
        this.myColor = "Red";
    }
}
