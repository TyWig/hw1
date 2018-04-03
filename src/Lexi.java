// Composite(163): Client
// AbstractFactory(87).Client
// FactoryMethod(107).Client
// Bridge(151).Client

import glyph.Character;
import widget.GUIFactory;
import window.*;
import glyph.*;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Random;

public class Lexi {

    public static void main(String[] args) {
        Window window = new Window("Lexi");
        GUIFactory factory = GUIFactory.getInstance();
        String[] words = {"PQ", "ab", "abc d e fg h", "dogs"};
        Glyph doc = new Column(window);
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
        doc.insert(new Glyph[]{row1, row2, button});

        window.setContents(doc);
    }

    // TODO: Get this working properly.
    private static class RandomGlyphGenerator {
        private final Random rand = new Random();
        private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        private final SecureRandom rnd;
        private GUIFactory factory;
        private Glyph root;
        private Window window;

        private RandomGlyphGenerator(GUIFactory factory, Window window, Glyph root) {
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

        Glyph[] generateRandomGlyphs() {
            Glyph[] glyphs = new Glyph[10];
            Glyph column = new Column(this.window);
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
              Glyph button = this.factory.createButton(window);
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
}
