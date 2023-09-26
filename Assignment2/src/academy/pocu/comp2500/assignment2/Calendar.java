package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private static final ColorType CALENDAR_COLOR = ColorType.WHITE;

    protected Calendar(int width, int height, int price) {
        super(ProductType.CALENDAR, CALENDAR_COLOR, width, height, price);
    }
}
