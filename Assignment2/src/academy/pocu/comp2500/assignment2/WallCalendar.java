package academy.pocu.comp2500.assignment2;

public class WallCalendar extends Calendar {
    private static final int WIDTH_IN_MILLI = 400;
    private static final int HEIGHT_IN_MILLI = 400;
    private static final int PRICE = 1000;

    public WallCalendar() {
        super(WIDTH_IN_MILLI, HEIGHT_IN_MILLI, PRICE);
    }
}
