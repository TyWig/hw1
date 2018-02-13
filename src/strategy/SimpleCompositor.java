package strategy;

import glyph.Composition;
import glyph.Cursor;
import glyph.Glyph;
import window.Window;

import java.util.Iterator;


// every composition should have a reference to a compositor
public class SimpleCompositor implements Compositor {

    private Window window;
    private Composition composition;
    private Cursor bounds;

    public SimpleCompositor(Window window) {
        this.window = window;
        this.bounds = new Cursor();
    }

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void compose() {
        Glyph last = composition;
        Glyph next = last.getParent();
        while(next != null) {
            last = next;
            next = next.getParent();
        }



//        while(it.hasNext()){
//            Glyph curr = it.next();
//            try{
//                curr.compose();
//            }catch(UnsupportedOperationException ex){
//                System.out.println("something happened boi.");
//            }
//        }
    }
}
