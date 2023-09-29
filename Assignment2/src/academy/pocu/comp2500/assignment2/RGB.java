package academy.pocu.comp2500.assignment2;

public class RGB {
    private final int r;
    private final int g;
    private final int b;
    private int colorValue;

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;

        colorValue |= r << 16 | g << 8 | b;
    }
    public RGB(int color) {
        this.r = color >> 16 & 0xFF;
        this.g = color >> 8 & 0xFF;
        this.b = color & 0xFF;
        this.colorValue = color;
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
        return colorValue;
    }

    public boolean equals(RGB color) {
        return this.colorValue == color.colorValue;
    }
}
