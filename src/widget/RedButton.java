package widget;

import glyph.Button;
import window.Window;

//FactoryMethod(107).ConcreteProduct
//AbstractFactory(87).ConcreteProduct

class RedButton extends Button {

    RedButton(Window window) {
        super(window);
        this.myColor = "Red";
    }
}
