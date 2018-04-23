package visitor;

import glyph.Character;
import glyph.Column;
import glyph.CompositeGlyph;
import glyph.Row;

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
    public void visit(Row glyph) {
        String s = this.convertCharArrayToWord();
        this.words.add(s);
        myChars.clear();
    }

    @Override
    public void visit(Column glyph) {
        String s = this.convertCharArrayToWord();
        this.words.add(s);
        myChars.clear();
    }

//    @Override
//    public void visit(CompositeGlyph glyph) {
//        String s = this.convertCharArrayToWord();
//        this.words.add(s);
//        myChars.clear();
//    }

    @Override
    public String toString() {
        String lastWord = this.convertCharArrayToWord();
        StringBuilder sb = new StringBuilder();
        for(String s: words) {
            sb.append(s).append(" ");
        }
        sb.append(lastWord);
        this.words.clear();
        this.myChars.clear();
        return sb.toString();
    }

    private String convertCharArrayToWord()
    {
        StringBuilder sb = new StringBuilder();
        for(java.lang.Character c: myChars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
