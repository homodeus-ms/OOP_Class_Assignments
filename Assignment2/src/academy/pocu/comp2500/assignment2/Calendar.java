package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private static final int WALL_CALENDAR_PRICE = 1000;
    private static final int DESK_CALENDAR_PRICE = 1000;
    private static final int MAGNET_CALENDAR_PRICE = 1500;

    private static final Color WHITE = Color.WHITE;

    public enum CalendarType {
        WALL_CALENDAR(ProductType.WALL_CALENDAR),
        DESK_CALENDAR(ProductType.DESK_CALENDAR),
        MAGNET_CALENDAR(ProductType.MAGNET_CALENDAR);

        private final ProductType productType;

        CalendarType(ProductType type) {
            this.productType = type;
        }

        public ProductType getProductType() {
            return productType;
        }
    }

    private final CalendarType calendarType;

    public Calendar(CalendarType type) {
        super(type.getProductType(), WHITE, getPrice(type));
        this.calendarType = type;
    }

    public CalendarType getCalendarType() {
        return calendarType;
    }

    private static int getPrice(CalendarType type) {
        switch (type) {
            case WALL_CALENDAR:
                return WALL_CALENDAR_PRICE;
            case DESK_CALENDAR:
                return DESK_CALENDAR_PRICE;
            case MAGNET_CALENDAR:
                return MAGNET_CALENDAR_PRICE;
            default:
                assert (false);
                return -1;
        }
    }
}
