package glyph;

import window.Window;
import java.util.LinkedList;

//Composite(165).Component

public abstract class CompositeGlyph extends Composition {
    LinkedList<Glyph> children;

    CompositeGlyph(Window window) {
        super(window);
        this.children = new LinkedList<>();
    }

    @Override
    public void draw(Window window) {
        for (Glyph child : this.children) {
            child.draw(window);
        }
    }

    @Override
    public void insert(Glyph glyph, int position) {
        this.children.add(glyph);
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

    @Override
    public Glyph child(int position) {
        if(position >= children.size()) return null;
        return this.children.get(position);
    }
}
