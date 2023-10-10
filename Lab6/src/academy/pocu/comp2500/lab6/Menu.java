package academy.pocu.comp2500.lab6;

public class Menu {
    protected static final int HOUSE_PIZZA_PRICE = 20;
    protected static final int MEAT_LOVER_PIZZA_PRICE = 21;
    protected static final int VEGGIE_PIZZA_PRICE = 17;
    protected static final int FREE_SOUL_PIZZA_PRICE = 25;
    protected static final int NO_HEAVY_MEAL_PRICE = 15;
    protected static final int THREE_COURSE_MEAL_PRICE = 25;
    protected static final int DEATH_BY_DESSERTS_PRICE = 20;

    private final int price;

    protected Menu(int price) {
        this.price = price;
    }
    public int getPrice() {
        return this.price;
    }
}
