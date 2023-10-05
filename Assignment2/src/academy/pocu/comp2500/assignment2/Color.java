package academy.pocu.comp2500.assignment2;

public class Color {
    private static final int RGB_MAX = 255;
    private static final int RGB_MIN = 0;

    public static final Color RED = new Color(0xFF, 0, 0);
    public static final Color GREEN = new Color(0, 0x80, 0);
    public static final Color BLUE = new Color(0, 0, 0xFF);
    public static final Color WHITE = new Color(0xFF, 0xFF, 0xFF);
    public static final Color GRAY = new Color(0xE6, 0xE6, 0xE6);
    public static final Color IVORY = new Color(0xFF, 0xFF, 0xF0);

    private final int r;
    private final int g;
    private final int b;

    public Color(int r, int g, int b) {
        r = Math.min(RGB_MAX, r);
        r = Math.max(RGB_MIN, r);
        g = Math.min(RGB_MAX, g);
        g = Math.max(RGB_MIN, g);
        b = Math.min(RGB_MAX, b);
        b = Math.max(RGB_MIN, b);

        this.r = r;
        this.g = g;
        this.b = b;
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
}
