// Composite(163): Client

import glyph.Character;
import window.*;
import glyph.*;

public class Lexi {

    public static void main(String[] args) {
        Window window = new SwingWindow("Hello");
        Glyph row1 = new Row(window);
        Glyph row2 = new Row(window);
        Glyph row3 = new Row(window);
        Glyph column = new Column(window);
        Glyph column2 = new Column(window);
        Glyph doc = new Column(window);

        column.insert(new Character('x'), 0);
        column.insert(new Character('y'), 1);
        column.insert(new Character('z'), 2);

        column2.insert(new Character('x'), 0);
        column2.insert(new Character('y'), 1);
        column2.insert(new Character('z'), 2);

        row1.insert(new Character('a'), 0);
        row1.insert(new Rectangle(10,20), 1);
        row1.insert(column, 2);
        row1.insert(new Character('b'), 2);
        row1.insert(new Character('c'), 2);

        row2.insert(new Character('x'), 0);
        row2.insert(new Rectangle(20, 10), 1);
        row2.insert(new Character('y'), 2);

        row3.insert(new Character('a'),0);
        row3.insert(column2, 1);
        row3.insert(new Character('b'),0);


        doc.insert(row1, 0);
        doc.insert(row2, 1);
        doc.insert(row3, 2);
        window.setContents(doc);
    }
}
