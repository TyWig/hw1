package iterator;

import glyph.Glyph;

// Iterator(257).ConcreteIterator
// FactoryMethod(107).ConcreteProduct

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
    public Glyph first() {
        return null;
    }

    @Override
    public Glyph current() {
        return null;
    }
}
