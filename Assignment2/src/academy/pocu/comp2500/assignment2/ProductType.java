package academy.pocu.comp2500.assignment2;

public enum ProductType {

    STAMP_4X3(40, 30, "Stamp (40mm x 30mm)"),
    STAMP_5X2(50, 20, "Stamp (50mm x 20mm)"),
    STAMP_7X4(70, 40, "Stamp (70mm x 40mm)"),
    WALL_CALENDAR(400, 400, "Wall Calendar"),
    DESK_CALENDAR(200, 150, "Desk Calendar"),
    MAGNET_CALENDAR(100, 200, "Magnet Calendar"),
    BANNER_1XHALF(1000, 500, "Banner (1000mm x 500mm)"),
    BANNER_1X1(1000, 1000, "Banner (1000mm x 1000mm)"),
    BANNER_2XHALF(2000, 500, "Banner (2000mm x 500mm)"),
    BANNER_3X1(3000, 1000, "Banner (3000mm x 1000mm"),
    LINEN_BUSINESS_CARD(90, 50, "Linen Business Card"),
    LAID_BUSINESS_CARD(90, 50, "Laid Business Card"),
    SMOOTH_BUSINESS_CARD(90, 50, "Smooth Business Card");

    private final int widthInMilli;
    private final int heightInMilli;
    private final String displayName;

    ProductType(int width, int height, String displayName) {
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.displayName = displayName;
    }

    public int getWidthInMilli() {
        return widthInMilli;
    }

    public int getHeightInMilli() {
        return heightInMilli;
    }

    public String getDisplayName() {
        return this.displayName;
    }


}
