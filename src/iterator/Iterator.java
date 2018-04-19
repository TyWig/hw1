package iterator;

import glyph.Glyph;

public interface Iterator {
    Glyph first();
    boolean hasNext();
    Glyph next();
    Glyph current();
}
