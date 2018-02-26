package glyph;

import window.Window;

abstract class Embellishment extends CompositeGlyph {

    Embellishment(Window window) {
        super(window);
    }

    @Override
    public void insert(Glyph glyph, int position) {
        this.children.getFirst().insert(glyph, position);
//        if(this.children.size() == 0) {
//            this.children.add(glyph);
//            glyph.setParent(this);
//            Glyph root = goToRoot();
//            root.compose();
//        }
//        else {
//            this.children.get(0).insert(glyph, 0);
//        }
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
