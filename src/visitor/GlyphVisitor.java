package visitor;

import glyph.Character;
import glyph.Rectangle;
import glyph.Row;
import glyph.CompositeGlyph;

public abstract class GlyphVisitor {

    public abstract void visit(Character glyph);

    public void visit(Rectangle glyph) { }

    public void visit(CompositeGlyph glyph) { }
}
