package iterator;

import glyph.Glyph;
import java.util.Stack;

// Iterator(257).ConcreteIterator
// FactoryMethod(107).ConcreteProduct

public class PreorderIterator implements Iterator {
    private Stack<Iterator> stack;
    private Glyph contents;
    private int curr;

    public PreorderIterator(Glyph contents) {
        this.curr = 0;
        this.contents = contents;
        this.stack = new Stack<>();
    }

    @Override
    public Glyph first() {
        Iterator firstIt = this.contents.createIterator();
        firstIt.first();
        stack.push(firstIt);
        return firstIt.current();
    }

    @Override
    public boolean hasNext() {
        return !stack.empty() && stack.peek().hasNext();
    }

    @Override
    public boolean done() {
        return false;
    }

    @Override
    public Glyph next() {
        Iterator currentTop = stack.peek();
        Glyph curr = currentTop.current();
        Iterator newIterator = curr.createIterator();
        newIterator.first();
        stack.push(newIterator);

        while(!stack.empty() && !stack.peek().hasNext()) {
            stack.pop();
        }

        if(!stack.empty() && stack.peek().hasNext()) {
            return stack.peek().next();
        }

        return stack.peek().current();
    }

    @Override
    public Glyph current() {
        Iterator top = stack.peek();
        return top.current();
    }
}
