package glyph;

public class Cursor {
    public int x;
    public int y;
    public int height;
    public int width;

    public void reset() {
        height = width = 0;
    }

    public void setBounds(Cursor cursor) {
        this.x = cursor.x;
        this.y = cursor.y;
        this.width = cursor.width;
        this.height = cursor.height;
    }
}
