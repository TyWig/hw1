// Composite(163): Client
// AbstractFactory(87).Client
// FactoryMethod(107).Client
// Bridge(151).Client
// Command(233).Client

import command.*;
import glyph.Character;
import widget.GUIFactory;
import window.*;
import glyph.*;


public class Lexi {

    public static void main(String[] args) {
        Window window = new ApplicationWindow("Lexi");
        Glyph doc = new Column(window);
        GUIFactory factory = GUIFactory.getInstance();
        String[] words = {"PQ", "ab", "abc d e fg h", "dogs"};

        window.addKey('i', new IncreaseFontSizeCommand(window));
        window.addKey('d', new DecreaseFontSizeCommand(window));
        window.addKey('r', new RedoCommand(window));
        window.addKey('u', new UndoCommand(window));
        window.addKey('w', new PrintWordsCommand(window, doc));
//        Glyph row = new Row(window);
//        row.insert(new Character('a'));
//        row.insert(new Character('b'));
//        row.insert(new Character('c'));

        Glyph row1 = new Row(window);
        row1.insert(new Character('a'));
        row1.insert(new Rectangle(10,20));

        Glyph col1 = new Column(window);
        col1.insert(new Character('X'));
        Label myButton = factory.createLabel(window);
        Glyph glyph = new Row(words[1], window);
        myButton.insert(glyph);
        col1.insert(myButton);
        col1.insert(new Character('Z'));
        row1.insert(col1);
        row1.insert(new Character('b'));

        Glyph row2 = new Row(window);
        row2.insert(new Character('x'));
        row2.insert(new Rectangle(20,10));
        row2.insert(new Character('y'));

        Glyph button = factory.createButton(window);
        button.insert(new Row(words[0], window));

        Glyph row = new Row(window);
        Glyph increaseButton = factory.createButton(window, new IncreaseFontSizeCommand(window));
        increaseButton.insert(new Row("+", window));
        Glyph decreaseButton = factory.createButton(window, new DecreaseFontSizeCommand(window));
        decreaseButton.insert(new Row("-", window));
        Glyph setTo14Button = factory.createButton(window, new SetFontSizeCommand(window, 14));
        setTo14Button.insert(new Row("14", window));
        Glyph setTo20Button = factory.createButton(window, new SetFontSizeCommand(window, 20));
        setTo20Button.insert(new Row("20", window));
        row.insert(new Glyph[]{increaseButton, decreaseButton, setTo14Button, setTo20Button});


        doc.insert(new Glyph[]{row1, row2, button, row});
//        doc.insert(row);
        window.setContents(doc);
    }
}
