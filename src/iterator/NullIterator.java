package iterator;

import glyph.Glyph;

public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Glyph next() {
        return null;
    }

    @Override
    public Glyph current() {
        return null;
    }
}
