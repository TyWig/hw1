package widget;

import command.Command;
import glyph.Button;
import window.Window;

//FactoryMethod(107).ConcreteProduct
//AbstractFactory(87).ConcreteProduct

class GreenButton extends Button {

    GreenButton(Window window, Command command) {
        super(window, command);
        this.myColor = "Green";
    }

    GreenButton(Window window) {
        super(window);
        this.myColor = "Green";
    }
}
