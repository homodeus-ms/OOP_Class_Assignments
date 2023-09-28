package academy.pocu.comp2500.assignment2;

public enum RGB {
    RED(0xFF, 0, 0),
    GREEN(0, 0x80, 0),
    BLUE(0, 0, 0xFF),
    WHITE(0xFF, 0xFF, 0xFF),
    GRAY(0xE6, 0xE6, 0xE6),
    IVORY(0xFF, 0xFF, 0xF0),
    CUSTOM(0, 0, 0);

    private int r;
    private int g;
    private int b;

    RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public RGB makeCustom(int r, int g, int b) {
        CUSTOM.r = r;
        CUSTOM.g = g;
        CUSTOM.b = b;
        return RGB.CUSTOM;
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
