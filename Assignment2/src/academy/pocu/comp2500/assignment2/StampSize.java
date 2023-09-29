package academy.pocu.comp2500.assignment2;

public enum StampSize {
    STAMP_4X3(400, 300, 2300),
    STAMP_5X2(500, 200, 2300),
    STAMP_7X4(700, 400, 2600);

    final int widthInMilli;
    final int heightInMilli;
    final int price;

    StampSize(int width, int height, int price) {
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.price = price;
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
