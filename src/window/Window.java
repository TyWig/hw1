package window;

import glyph.*;

// Bridge(151).Abstraction

public class Window {
    private WindowImp window;
    private Glyph contents;

    public Window(String title) {
        window = WindowFactory.getInstance().createWindow(title, this);
    }

    public void draw() {
        contents.draw(this);
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

}
