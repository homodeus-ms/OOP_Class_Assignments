package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(RGB.RED),
    GREEN(RGB.GREEN),
    BLUE(RGB.BLUE);

    private final RGB color;

    StampColor(RGB color) {
        this.color = color;
    }
    public RGB getColor() {
        return this.color;
    }
    public int getColorValue() {
        return this.color.getColorValue();
    }
}
