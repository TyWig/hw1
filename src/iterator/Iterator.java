package iterator;

import glyph.Glyph;

public interface Iterator {
    boolean hasNext();
    Glyph next();
    Glyph current();
}
