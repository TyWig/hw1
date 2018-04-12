package window;

import command.*;
import glyph.*;

import java.util.Iterator;

// Bridge(151).Abstraction

public abstract class Window {
    private WindowImp window;
    private Glyph contents;
    private KeyMap keyMap;
    private CommandHistory commandHistory;

    public Window(String title) {
        window = WindowImpFactory.getInstance().createWindow(title, this);
        keyMap = new KeyMap();
        commandHistory = CommandHistory.getInstance();
        initKeyMap();
    }

    private void initKeyMap() {
        keyMap.put('i', new IncreaseFontSizeCommand(this));
        keyMap.put('d', new DecreaseFontSizeCommand(this));
        keyMap.put('r', new RedoCommand(this));
        keyMap.put('u', new UndoCommand(this));
    }

    public void draw() {
        contents.draw(this);
    }

    public void key(char c) {
        Command tryGet = keyMap.get(c);
        if(tryGet != null) {
            tryGet.execute();
            if(tryGet.isUndoable()) {
                commandHistory.add(tryGet.clone());
            }
        }
    }

    public void click(int x, int y) {
        Glyph found = contents.find(x,y);
        if(found != null) {
            Command command = found.click();
            if(command != null) {
                command.execute();
                commandHistory.add(command);
            }
        }
    }

    // Functions that are forwarded to WindowImp
    public void drawCharacter(char c, int x, int y) {
        window.drawCharacter(c, x, y);
    }
    public void drawRectangle(int x, int y, int width, int height) {
        window.drawRectangle(x, y, width, height);
    }
    public int charWidth(char c) {
        return window.charWidth(c);
    }
    public int charHeight(char c) {
        return window.charHeight(c);
    }
    public void setContents(Glyph glyph) {
        this.contents = glyph;
        window.setContents();
    }
    public void addBorder(int x1, int y1, int x2, int y2, int width) {
        window.addBorder(x1, y1, x2, y2, width);
    }
    public void addScrollBar(int x, int y, int width, int height) {
        window.addScrollBar(x, y, width, height);
    }
    public void drawButton(int x, int y, int width, int height, String color) {
        window.drawButton(x, y, width, height, color);
    }
    public void drawLabel(int x, int y, int width, int height, String color) {
        window.drawLabel(x, y, width, height, color);
    }
    public int getFontSize() {
        return window.getFontSize();
    }
    public void setFontSize(int size) {
        window.setFontSize(size);
    }
    public void repaint() {
        this.contents.compose();
        window.repaint();
    }
    public void undoCommand() {
        commandHistory.undo();
    }
    public void redoCommand() {
        commandHistory.redo();
    }

}
