package academy.pocu.comp2500.assignment2;

public class RGB {

    public static final RGB RED = new RGB(0xFF, 0, 0);
    public static final RGB GREEN = new RGB(0x0, 0x80, 0);
    public static final RGB BLUE = new RGB(0, 0, 0xFF);
    public static final RGB WHITE = new RGB(0xFF, 0xFF, 0xFF);
    public static final RGB GRAY = new RGB(0xE6, 0xE6, 0xE6);
    public static final RGB IVORY = new RGB(0xFF, 0xFF, 0xF0);

    private final int r;
    private final int g;
    private final int b;

    public RGB(int r, int g, int b) {
        r = Math.min(255, r);
        r = Math.max(0, r);
        g = Math.min(255, g);
        g = Math.max(0, g);
        b = Math.min(255, b);
        b = Math.max(0, b);

        this.r = r;
        this.g = g;
        this.b = b;
    }
    /*public RGB(int color) {
        this.r = color >> 16 & 0xFF;
        this.g = color >> 8 & 0xFF;
        this.b = color & 0xFF;
    }*/

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public boolean equals(RGB color) {
        return this.r == color.r && this.g == color.g && this.b == color.b;
    }
}
