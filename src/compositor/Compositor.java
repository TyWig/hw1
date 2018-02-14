package compositor;

import glyph.Composition;

//Strategy(315).Strategy

public interface Compositor {
    void setComposition(Composition composition);
    void compose();
}
