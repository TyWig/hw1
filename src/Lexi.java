// Composite(163): Client

import window.*;
import glyph.*;

public class Lexi {

    public static void main(String[] args) {
        Window window = new SwingWindow("Hello");
        String[] words = {"testing", "idk", "c", "d!"};
        Glyph column3 = new Column(words, window);
        Glyph column4 = new Column(words.clone(), window);

        Glyph row = new Row(window);
        Glyph row2 = new Row(window);

        row2.insert(new Glyph[]{column3});
        row.insert(new Glyph[]{column4});
        Glyph column5 = new Column(window);
        column5.insert(new Glyph[]{row2});

        Glyph scroller = new ScrollBar(window, column5, 10);
        Glyph border2 = new Border(window, scroller);
        window.setContents(border2);
    }
}
