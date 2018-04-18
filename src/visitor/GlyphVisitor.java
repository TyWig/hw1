package visitor;

import glyph.Glyph;

public abstract class GlyphVisitor {

    public void visit(Glyph glyph) {
        glyph.accept(this);
    }
}
