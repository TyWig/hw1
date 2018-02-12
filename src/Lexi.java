// Below is what we need to have at the top of every file "DesignPattern(page): participant"
// Composite(163): Leaf

import glyph.Character;
import window.*;
import glyph.*;

public class Lexi {

    public static void main(String[] args) {
        Window window = new SwingWindow("Hello");

        CompositeGlyph row1 = new Row();
        CompositeGlyph row2 = new Row();
        CompositeGlyph column = new Column();

        CompositeGlyph doc = new Column();

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

        doc.insert(row1, 0);
        doc.insert(row2, 1);

        window.setContents(doc);
    }
}
