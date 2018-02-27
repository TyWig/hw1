package glyph;

import window.Window;

abstract class Embellishment extends CompositeGlyph {

    Embellishment(Window window) {
        super(window);
    }

    @Override
    public void insert(Glyph glyph) {
        this.children.getFirst().insert(glyph);
    }

    @Override
    public void remove(Glyph glyph) {
        if(this.children.size() == 0) {
            throw new UnsupportedOperationException();
        } else {
            this.children.getFirst().remove(glyph);
        }
    }

    @Override
    public Glyph child(int position) {
        int childrenSize = this.children.size();
        if(position >= childrenSize && childrenSize == 1) {
            return this.children.getFirst().child(position);
        } else if(childrenSize == 1) {
            return this.children.getFirst();
        } else {
            return null;
        }
    }
}
