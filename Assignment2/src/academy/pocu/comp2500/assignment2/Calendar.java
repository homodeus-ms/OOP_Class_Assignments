package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    public static final RGB CALENDAR_COLOR = RGB.WHITE;
    public static final int WALL_CALENDAR_PRICE = 1000;
    public static final int DESK_CALENDAR_PRICE = 1000;
    public static final int MAGNET_CALENDAR_PRICE = 1500;

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
