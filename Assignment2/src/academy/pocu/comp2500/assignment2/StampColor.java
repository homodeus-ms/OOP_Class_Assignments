package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(new RGB(0xFF0000)),
    GREEN(new RGB(0x8000)),
    BLUE(new RGB(0xFF));

    private final RGB color;

    StampColor(RGB color) {
        this.color = color;
    }
    public RGB getColor() {
        return this.color;
    }
}
