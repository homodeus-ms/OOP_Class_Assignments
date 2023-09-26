package academy.pocu.comp2500.assignment2;

public enum ColorType {
    RED(255, 0, 0),
    GREEN(0, 80, 0),
    BLUE(0, 0, 255),
    WHITE(255, 255, 255),
    GRAY(230, 230, 230),
    IVORY(255, 255, 240),
    CUSTOM(0, 0, 0);

    private int R;
    private int G;
    private int B;

    ColorType(int r, int g, int b) {
        R = r;
        G = g;
        B = b;
    }
    public int getR() {
        return this.R;
    }
    public int getG() {
        return this.G;
    }
    public int getB() {
        return this.B;
    }
    public void setCustomColor(int r, int g, int b) {
        CUSTOM.R = r;
        CUSTOM.G = g;
        CUSTOM.B = b;
    }

}
