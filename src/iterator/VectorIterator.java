package iterator;

import glyph.Glyph;
import java.util.LinkedList;

// Iterator(257).ConcreteIterator
// FactoryMethod(107).ConcreteProduct

public class VectorIterator implements Iterator {
    private LinkedList<Glyph> glyphs;
    private int curr = 0;

    public VectorIterator(LinkedList<Glyph> glyphs) {
        this.glyphs = glyphs;
    }

    @Override
    public Glyph first() {
        curr = 0;
        return glyphs.get(curr);
    }

    @Override
    public boolean hasNext() {
        return curr < glyphs.size();
    }

    @Override
    public Glyph next() {
        Glyph c = glyphs.get(curr);
        curr++;
        return c;
    }

    @Override
    public Glyph current() {
        return glyphs.get(curr);
    }
}
