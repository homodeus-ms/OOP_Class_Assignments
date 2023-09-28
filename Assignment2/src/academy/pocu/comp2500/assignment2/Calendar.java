package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private static final int CALENDAR_COLOR = 0xFFFFFF;

    private static final int WALL_CALENDAR_WIDTH = 400;
    private static final int WALL_CALENDAR_HEIGHT = 400;
    private static final int DESK_CALENDAR_WIDTH = 200;
    private static final int DESK_CALENDAR_HEIGHT = 150;
    private static final int MAGNET_CALENDAR_WIDTH = 100;
    private static final int MAGNET_CALENDAR_HEIGHT = 200;

    private static final int WALL_CALENDAR_PRICE = 1000;
    private static final int DESK_CALENDAR_PRICE = 1000;
    private static final int MAGNET_CALENDAR_PRICE = 1500;

    private final CalendarType calendarType;

    public Calendar(CalendarType type) {
        super(getProductType(type), RGB.WHITE, getWidth(type), getHeight(type), getPrice(type));
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

    private static int getWidth(CalendarType type) {
        switch (type) {
            case WALL_CALENDAR:
                return WALL_CALENDAR_WIDTH;
            case DESK_CALENDAR:
                return DESK_CALENDAR_WIDTH;
            case MAGNET_CALENDAR:
                return MAGNET_CALENDAR_WIDTH;
            default:
                assert (false);
                return -1;
        }
    }
    private static int getHeight(CalendarType type) {
        switch (type) {
            case WALL_CALENDAR:
                return WALL_CALENDAR_HEIGHT;
            case DESK_CALENDAR:
                return DESK_CALENDAR_HEIGHT;
            case MAGNET_CALENDAR:
                return MAGNET_CALENDAR_HEIGHT;
            default:
                assert (false);
                return -1;
        }
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
