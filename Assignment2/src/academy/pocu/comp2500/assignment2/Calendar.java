package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private static final RGB CALENDAR_COLOR = RGB.WHITE;

    private static final int WALL_CALENDAR_WIDTH = 400;
    private static final int WALL_CALENDAR_HEIGHT = 400;
    private static final int DESK_CALENDAR_WIDTH = 200;
    private static final int DESK_CALENDAR_HEIGHT = 150;
    private static final int MAGNET_CALENDAR_WIDTH = 100;
    private static final int MAGNET_CALENDAR_HEIGHT = 200;

    private static final int WALL_CALENDAR_PRICE = 1000;
    private static final int DESK_CALENDAR_PRICE = 1000;
    private static final int MAGNET_CALENDAR_PRICE = 1500;

    public enum CalendarType {
        WALL_CALENDAR(ProductSize.WALL_CALENDAR, WALL_CALENDAR_PRICE),
        DESK_CALENDAR(ProductSize.DESK_CALENDAR, DESK_CALENDAR_PRICE),
        MAGNET_CALENDAR(ProductSize.MAGNET_CALENDAR, MAGNET_CALENDAR_PRICE);

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

    private final CalendarType calendarType;

    public Calendar(CalendarType type) {
        super(getProductType(type), CALENDAR_COLOR, type.getSize(), type.getPrice());
        this.calendarType = type;
    }

    public CalendarType getCalendarType() {
        return this.calendarType;
    }

    private static String getDisplayName(CalendarType type) {
        switch (type) {
            case WALL_CALENDAR:
                return "Wall Calendar";
            case DESK_CALENDAR:
                return "Desk Calendar";
            case MAGNET_CALENDAR:
                return "Magnet Calendar";
            default:
                assert (false);
                return "";
        }
    }

    private static ProductType getProductType(CalendarType type) {
        switch (type) {
            case WALL_CALENDAR:
                return ProductType.CALENDAR_WALL;
            case DESK_CALENDAR:
                return ProductType.CALENDAR_DESK;
            case MAGNET_CALENDAR:
                return ProductType.CALENDAR_MAGNET;
            default:
                assert (false);
                return ProductType.DEFAULT;
        }
    }

    /*private static ProductSize getSize(CalendarType type) {
        switch (type) {
            case WALL_CALENDAR:
                return ProductSize.WALL_CALENDAR;
            case DESK_CALENDAR:
                return ProductSize.DESK_CALENDAR;
            case MAGNET_CALENDAR:
                return ProductSize.MAGNET_CALENDAR;
            default:
                assert (false);
                return ProductSize.WALL_CALENDAR;
        }
    }*/


    /*private static int getPrice(CalendarType type) {
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
    }*/
}
