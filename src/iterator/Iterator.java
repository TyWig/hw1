package iterator;

import glyph.Glyph;

// Iterator(257).Iterator
// FactoryMethod(107).Product

public interface Iterator {
    Glyph first();
    boolean hasNext();
    Glyph next();
    Glyph current();
}
