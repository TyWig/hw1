package command;

import glyph.Glyph;
import iterator.Iterator;
import iterator.PreorderIterator;
import visitor.GlyphVisitor;
import visitor.WordsVisitor;
import window.Window;

// Command(233).ConcreteCommand
// Prototype(117).ConcretePrototype

public class PrintWordsCommand extends Command {
    private Glyph contents;
    private GlyphVisitor visitor;

    public PrintWordsCommand(Window window, Glyph contents) {
        super(window);
        this.contents = contents;
        this.visitor = new WordsVisitor();
    }

    @Override
    public boolean isUndoable() {
        return false;
    }

    @Override
    public void execute() {
        Iterator i = new PreorderIterator(this.contents);
        for(i.first(); i.hasNext(); i.next()) {
            Glyph curr = i.current();
            curr.accept(this.visitor);
        }
        System.out.println(this.visitor.toString());
    }

    @Override
    public void unexecute() { }

    @Override
    public Command clone() {
        return this;
    }
}
