package glyph;

import command.Command;
import window.Window;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

//Composite(165).Component
//Decorator(175).ConcreteComponent

public abstract class CompositeGlyph extends Composition {
    protected LinkedList<Glyph> children;

    CompositeGlyph(Window window) {
        super(window);
        this.children = new LinkedList<>();
    }

    @Override
    public boolean find(int x, int y) {
        for(Glyph child: this.children) {
            if(child.find(x, y)) {


            }
        }
        return false;
    }

    @Override
    public Iterator<Glyph> getIterator() {
        return this.children.iterator();
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

    @Override
    public Glyph child(int position) {
        if(position >= children.size()) return null;
        return this.children.get(position);
    }
}
