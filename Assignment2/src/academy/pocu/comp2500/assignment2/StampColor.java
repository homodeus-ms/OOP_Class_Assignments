package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(new RGB(255, 0, 0)),
    GREEN(new RGB(0, 80, 0)),
    BLUE(new RGB(0, 0, 0xFF));

    private RGB rgb;

    StampColor(RGB color) {
        this.rgb = color;
    }

    public RGB getRGB() {
        return this.rgb;
    }
}
