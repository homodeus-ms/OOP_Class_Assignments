package academy.pocu.comp2500.assignment2;

public enum ProductSize {
    STAMP_4x3(400, 300),
    STAMP_5x2(500, 200),
    STAMP_7x4(700, 400),
    WALL_CALENDAR(400, 400),
    DESK_CALENDAR(200, 150),
    MAGNET_CALENDAR(100, 200),
    BANNER_1xHALF(1000, 500),
    BANNER_1x1(1000, 1000),
    BANNER_2xHALF(2000, 500),
    BANNER_3x1(3000, 1000),
    BUSINESS_CARD(90, 50),
    DEFAULT(0, 0);

    private final int widthInMilli;
    private final int heightInMilli;

    ProductSize(int width, int height) {
        this.widthInMilli = width;
        this.heightInMilli = height;
    }

    public int getWidthInMilli() {
        return widthInMilli;
    }

    public int getHeightInMilli() {
        return heightInMilli;
    }
}
