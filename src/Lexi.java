// Composite(163): Client

import window.*;
import glyph.*;

public class Lexi {

    public static void main(String[] args) {
        Window window = new SwingWindow("Hello");
        String[] words = {"Testing", "Another Word", "Idk", "plz work!"};
        Glyph column3 = new Column(words, window);
        Glyph column4 = new Column(words, window);
        Glyph column = new Column(words, window);
        Glyph column2 = new Column(words, window);
        Glyph row = new Row(window);
        Glyph row2 = new Row(window);

        row2.insert(new Glyph[]{column3, column4});
        row.insert(new Glyph[]{column, column2});
        Glyph column5 = new Column(window);
        column5.insert(new Glyph[]{row, row2});

        Glyph border = new Border(window, column5);
        Glyph scrolly = new ScrollBar(window, border, 10);
        window.setContents(scrolly);
    }
}
