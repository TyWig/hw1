// Below is what we need to have at the top of every file "DesignPattern(page): participant"
// Composite(163): Leaf

import glyph.Character;
import window.*;
import glyph.*;

public class Lexi {

    public static void main(String[] args) {
        Window window = new SwingWindow("Hello");

        Glyph row1 = new Row();
        Glyph row2 = new Row();
        Glyph column = new Column();

        Glyph column1 = new Composition(window);

        column.insert(new glyph.Character('x'), 0);
        column.insert(new glyph.Character('y'), 1);
        column.insert(new glyph.Character('z'), 2);

        row1.insert(new glyph.Character('a'), 0);
        row1.insert(new Rectangle(10,20), 1);
        row1.insert(column, 2);
        row1.insert(new glyph.Character('b'), 3);

        row2.insert(new glyph.Character('x'), 0);
        row2.insert(new glyph.Rectangle(20, 10), 1);
        row2.insert(new glyph.Character('y'), 2);

        column1.insert(row1, 0);
        column1.insert(row2, 1);

        window.setContents(column1);
    }
}
