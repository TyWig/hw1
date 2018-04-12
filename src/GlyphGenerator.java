import glyph.Column;
import glyph.Glyph;
import glyph.Rectangle;
import glyph.Row;
import widget.GUIFactory;
import window.Window;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Random;

public class GlyphGenerator {
    private final Random rand = new Random();
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final SecureRandom rnd;
    private GUIFactory factory;
    private Glyph root;
    private Window window;

    public GlyphGenerator(GUIFactory factory, Window window, Glyph root) {
        rnd = new SecureRandom();
        this.factory = factory;
        this.root = root;
        this.window = window;
    }

    private String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public Glyph[] generateRandomGlyphs() {
        Glyph[] glyphs = new Glyph[10];
        Glyph column = new Column(window);
        for(int i = 0; i < 10; i++) {
            Glyph randGlyph = generateRandomGlyph(this.window);
            if(i % 2 == 0) {
                Glyph col = new Column(this.window);
                Glyph row = new Row(this.window);
                Glyph row2 = new Row(this.window);
                row.insert(generateRandomGlyph(this.window));
                row2.insert(randGlyph);
                col.insert(new Glyph[]{row, row2});
                glyphs[i] = row;
            } else {
                glyphs[i] = randGlyph;
            }

        }
        for(int i = 0; i < glyphs.length; i ++) {
            if(i % 2 == 0 || i %3 == 0) {
                column.insert(glyphs[i]);
            } else {
                Glyph row = new Row(window);
                row.insert(glyphs[i]);
                column.insert(row);
            }
        }
        return new Glyph[]{column};
    }

    private Glyph generateRandomGlyph(Window window) {
        int randomNum = rand.nextInt();
        if(randomNum % 2 == 0) {
            LinkedList<String> strings = generateRandomPhrases();
            String[] phrases = new String[strings.size()];
            phrases = strings.toArray(phrases);
            return new Column(phrases, window);
        } else if(randomNum % 3 == 0) {
            return new Rectangle(rand.nextInt(30)+1, rand.nextInt(30)+1);
        } else {
            Glyph button = this.factory.createButton(window, null);
            button.insert(new Row(randomString(rand.nextInt(10)), window));
            return button;
        }
    }

    private LinkedList<String> generateRandomPhrases() {
        LinkedList<String> phrases = new LinkedList<>();
        for (int i = 0; i < rand.nextInt(10) + 1; i++) {
            int num = rand.nextInt(7) + 1;
            phrases.add(randomString(num));
        }
        return phrases;
    }
}
