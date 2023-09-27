package academy.pocu.comp2500.assignment2;

public class RGB {
    private int r;
    private int g;
    private int b;
    private int color;

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.color |= r << 16 | g << 8 | b;
    }
    public RGB(int color) {
        this.color = color;
        this.r = color >> 16 & 0xFF;
        this.g = color >> 8 & 0xFF;
        this.b = color & 0xFF;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getColorValue() {
        return color;
    }
}
