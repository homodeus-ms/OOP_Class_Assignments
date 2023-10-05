package academy.pocu.comp2500.assignment2;

public enum ProductType {

    STAMP_4X3(40, 30),
    STAMP_5X2(50, 20),
    STAMP_7X4(70, 40),
    WALL_CALENDAR(400, 400),
    DESK_CALENDAR(200, 150),
    MAGNET_CALENDAR(100, 200),
    BANNER_1XHALF(1000, 500),
    BANNER_1X1(1000, 1000),
    BANNER_2XHALF(2000, 500),
    BANNER_3X1(3000, 1000),
    LINEN_BUSINESS_CARD(90, 50),
    LAID_BUSINESS_CARD(90, 50),
    SMOOTH_BUSINESS_CARD(90, 50);

    private final int widthInMilli;
    private final int heightInMilli;

    ProductType(int width, int height) {
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
