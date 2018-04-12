package widget;

import command.Command;
import command.RedoCommand;
import glyph.Button;
import window.Window;

//FactoryMethod(107).ConcreteProduct
//AbstractFactory(87).ConcreteProduct

class RedButton extends Button {

    RedButton(Window window, Command command) {
        super(window, command);
        this.myColor = "Red";
    }

    RedButton(Window window) {
        super(window);
        this.myColor = "Red";
    }
}
