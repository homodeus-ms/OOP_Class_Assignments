package academy.pocu.comp2500.assignment2;

public enum CalendarType {

    WALL_CALENDAR(ProductSize.WALL_CALENDAR, Calendar.WALL_CALENDAR_PRICE),
    DESK_CALENDAR(ProductSize.DESK_CALENDAR, Calendar.DESK_CALENDAR_PRICE),
    MAGNET_CALENDAR(ProductSize.MAGNET_CALENDAR, Calendar.MAGNET_CALENDAR_PRICE);

    private final ProductSize size;
    private final int price;

    CalendarType(ProductSize size, int price) {
        this.size = size;
        this.price = price;
    }

    public ProductSize getSize() {
        return this.size;
    }

    public int getPrice() {
        return price;
    }
}
