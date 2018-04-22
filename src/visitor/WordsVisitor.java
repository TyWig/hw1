package visitor;

import glyph.Character;
import glyph.CompositeGlyph;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// Visitor(331).ConcreteVisitor

public class WordsVisitor extends GlyphVisitor {
    private List<String> words;
    private List<java.lang.Character> myChars;

    public WordsVisitor() {
        myChars = new ArrayList<>();
        words = new LinkedList<>();
    }

    @Override
    public void visit(Character glyph) {
        myChars.add(glyph.getChar());
    }

    @Override
    public void visit(CompositeGlyph glyph) {
        StringBuilder sb = new StringBuilder();
        for(java.lang.Character c: myChars) {
            sb.append(c);
        }
        words.add(sb.toString());
        myChars.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s: words) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
}
