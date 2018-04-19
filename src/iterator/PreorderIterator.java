package iterator;

import glyph.Glyph;

import java.util.LinkedList;
import java.util.Stack;

public class PreorderIterator implements Iterator {
    private Stack<Iterator> stack;
    private LinkedList<Glyph> glyphs;
    private int curr;

    public PreorderIterator(LinkedList<Glyph> glyphs) {
        this.glyphs = glyphs;
        curr = 0;
        stack = new Stack<>();
    }

    @Override
    public Glyph first() {
        Iterator firstIt = glyphs.get(curr).createIterator();
        Iterator firstGlyphIt = firstIt.first().createIterator();
        stack.push(firstGlyphIt);
        return glyphs.get(curr);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Glyph next() {
        return  null;
    }

    @Override
    public Glyph current() {
        Iterator top = stack.peek();
        return top.next();
    }
}
