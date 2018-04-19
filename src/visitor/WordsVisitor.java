package visitor;

import glyph.Character;

import java.util.List;
import java.util.ArrayList;

public class WordsVisitor extends GlyphVisitor {
    private List<Character> myChars;

    public WordsVisitor() {
        myChars = new ArrayList<Character>();
    }

    @Override
    public void visit(Character glyph) {
        myChars.add(new Character(glyph.getChar()));
    }
}
