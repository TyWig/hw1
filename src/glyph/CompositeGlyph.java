package glyph;

import iterator.VectorIterator;
import visitor.GlyphVisitor;
import window.Window;
import java.util.Arrays;
import java.util.LinkedList;
import iterator.Iterator;

// Composite(165).Component
// Decorator(175).ConcreteComponent
// ChainOfResponsibility(233).Handler
// Iterator(257).ConcreteAggregate
// Visitor(331).ConcreteElement
// FactoryMethod(107).Creator

public abstract class CompositeGlyph extends Composition {
    LinkedList<Glyph> children;


    CompositeGlyph(Window window) {
        super(window);
        this.children = new LinkedList<>();
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Glyph find(int x, int y) {
        for(Glyph child: this.children) {
            Glyph found = child.find(x,y);
            if(found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public Iterator createIterator() {
        return new VectorIterator(children);
    }

    @Override
    public void draw(Window window) {
        for (Glyph child : this.children) {
            child.draw(window);
        }
    }

    @Override
    public void insert(Glyph glyph) {
        this.children.add(glyph);
        glyph.setParent(this);
        Glyph root = goToRoot();
        root.compose();
    }

    @Override
    public void insert(Glyph[] glyphs) {
        this.children.addAll(Arrays.asList(glyphs));
        for(Glyph glyph: glyphs)
            glyph.setParent(this);
        Glyph root = goToRoot();
        root.compose();
    }

    @Override
    public void remove(Glyph glyph) {
        this.children.remove(glyph);
        glyph.setParent(null);
        Glyph root = goToRoot();
        root.compose();
    }


}
