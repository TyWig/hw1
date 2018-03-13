// Composite(163): Client

import widget.GUIFactory;
import window.*;
import glyph.*;

public class Lexi {

    public static void main(String[] args) {
        Window window = new SwingWindow("Hello");
        String[] words = {"testing", "idk", "c", "d!"};
        GUIFactory factory = GUIFactory.getInstance();
        Button myButton = factory.createButton(window);
        Glyph glyph = new Column(words, window);
        myButton.insert(glyph);
        Label label = factory.createLabel(window);
        label.insert(new Row(words[0], window));

        Glyph doc = new Column(window);
        doc.insert(new Glyph[]{myButton,label});

        window.setContents(doc);
    }
}
