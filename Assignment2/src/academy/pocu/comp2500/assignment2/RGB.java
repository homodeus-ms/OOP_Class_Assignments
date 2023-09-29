package academy.pocu.comp2500.assignment2;

public class RGB {

    public static final RGB RED = new RGB(0xFF0000);
    public static final RGB GREEN = new RGB(0x8000);
    public static final RGB BLUE = new RGB(0xFF);
    public static final RGB WHITE = new RGB(0xFFFFFF);
    public static final RGB GRAY = new RGB(0xE6E6E6);
    public static final RGB IVORY = new RGB(0xFFFFF0);

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
