package visitor;

import glyph.*;
import glyph.Character;

// Visitor(331).Visitor

public abstract class GlyphVisitor {

    public abstract void visit(Character glyph);

    public void visit(Glyph glyph) { }

    public void visit(Rectangle glyph) { }

    public void visit(CompositeGlyph glyph) { }
}
