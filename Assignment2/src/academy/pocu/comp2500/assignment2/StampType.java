package academy.pocu.comp2500.assignment2;

public enum StampType {
    RED_4X3(ColorType.RED, 400, 300, 2300),
    RED_5X2(ColorType.RED, 500, 200, 2300),
    RED_7X4(ColorType.RED, 700, 400, 2600),

    GREEN_4X3(ColorType.GREEN, 400, 300, 2300),
    GREEN_5X2(ColorType.GREEN, 500, 200, 2300),
    GREEN_7X4(ColorType.GREEN, 700, 400, 2600),

    BLUE_4X3(ColorType.BLUE, 400, 300, 2300),
    BLUE_5X2(ColorType.BLUE, 500, 200, 2300),
    BLUE_7X4(ColorType.BLUE, 700, 400, 2600);

    private ColorType color;
    private int widthInMilli;
    private int heightInMilli;
    private int price;

    StampType(ColorType color, int width, int height, int price) {
        this.color = color;
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.price = price;
    }

    public ColorType getColor() {
        return color;
    }

    public int getWidthInMilli() {
        return widthInMilli;
    }

    public int getHeightInMilli() {
        return heightInMilli;
    }

    public int getPrice() {
        return price;
    }
}
