package academy.pocu.comp2500.assignment2;

public class TextAperture {

    private int x_pos;
    private int y_pos;
    private int apertureWidth;
    private int apertureHeight;
    private String text;

    public TextAperture(int x, int y, int width, int height, String Text) {
        this.x_pos = x;
        this.y_pos = y;
        this.apertureWidth = width;
        this.apertureHeight = height;
        this.text = text;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public int getApertureWidth() {
        return apertureWidth;
    }

    public int getApertureHeight() {
        return apertureHeight;
    }

    public String getText() {
        return text;
    }
}
