package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GRAY(RGB.GRAY),
    IVORY(RGB.IVORY),
    WHITE(RGB.WHITE);

    private final RGB color;

    BusinessCardColor(RGB color) {
        this.color = color;
    }
    public RGB getColor() {
        return this.color;
    }
}
