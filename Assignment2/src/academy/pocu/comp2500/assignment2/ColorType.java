package academy.pocu.comp2500.assignment2;

public enum ColorType {
    RED(255, 0, 0),
    GREEN(0, 80, 0),
    BLUE(0, 0, 255),
    WHITE(255, 255, 255),
    GRAY(230, 230, 230),
    IVORY(255, 255, 240),
    CUSTOM(0, 0, 0);

    private int r;
    private int g;
    private int b;

    ColorType(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public int getR() {
        return this.r;
    }
    public int getG() {
        return this.g;
    }
    public int getB() {
        return this.b;
    }
    public void setCustomColor(int r, int g, int b) {
        CUSTOM.r = r;
        CUSTOM.g = g;
        CUSTOM.b = b;
    }

}
