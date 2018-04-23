package visitor;

import glyph.*;
import glyph.Character;

// Visitor(331).Visitor

public abstract class GlyphVisitor {

    public abstract void visit(Character glyph);
    public abstract void visit(Row glyph);
    public abstract void visit(Column glyph);

    public void visit(Glyph glyph) { }

    public void visit(Rectangle glyph) { }

    public void visit(CompositeGlyph glyph) { }
}
