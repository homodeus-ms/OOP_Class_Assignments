package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Menu {
    private static final int HOUSE_PIZZA_PRICE = 20;
    private static final int MEAT_LOVER_PIZZA_PRICE = 21;
    private static final int VEGGIE_PIZZA_PRICE = 17;
    private static final int FREE_SOUL_PIZZA_PRICE = 25;
    private static final int NO_HEAVY_MEAL_PRICE = 15;
    private static final int THREE_COURSE_MEAL_PRICE = 25;
    private static final int DEATH_BY_DESSERTS_PRICE = 20;

    protected static final int HOUSE_PIZZA_MAX_MEAT_COUNT = 2;
    protected static final int MEAT_PIZZA_MAX_VEGGIE_COUNT = 1;
    protected static final int VEGGIE_PIZZA_MAX_CHEESE_COUNT = 2;
    protected static final int FREE_PIZZA_MAX_MEAT_COUNT = 2;
    protected static final int FREE_PIZZA_MAX_VEGGIE_COUNT = 2;
    protected static final int FREE_PIZZA_MAX_CHEESE_COUNT = 1;

    private final int price;
    protected final MenuType menu;
    protected int addedMeatCount;
    protected int addedVeggieCount;
    protected int addedCheeseCount;

    protected final ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected final ArrayList<MainCourse> mainCourses = new ArrayList<>();
    protected final ArrayList<Dessert> desserts = new ArrayList<>();

    protected Menu(MenuType menu) {
        this.menu = menu;
        this.price = getPrice(menu);
    }

    public int getPrice() {
        return price;
    }
    /*public MenuType getMenu() {
        return menu;
    }*/

    public boolean isValid() {
        switch (menu) {
            case HOUSE_PIZZA:
                return addedMeatCount == HOUSE_PIZZA_MAX_MEAT_COUNT;
            case MEAT_LOVER_PIZZA:
                return addedVeggieCount == MEAT_PIZZA_MAX_VEGGIE_COUNT;
            case VEGGIE_PIZZA:
                return addedCheeseCount == VEGGIE_PIZZA_MAX_CHEESE_COUNT;
            case FREE_SOUL_PIZZA:
                return addedMeatCount == FREE_PIZZA_MAX_MEAT_COUNT &&
                        addedVeggieCount == FREE_PIZZA_MAX_VEGGIE_COUNT &&
                        addedCheeseCount == FREE_PIZZA_MAX_CHEESE_COUNT;
            case NO_HEAVY_MEAL:
                return appetizers.size() == 2 && desserts.size() == 1;
            case THREE_COURSE_MEAL:
                return appetizers.size() == 1 && mainCourses.size() == 1 && desserts.size() == 1;
            case DEATH_BY_DESSERTS:
                return desserts.size() == 4;
            default:
                assert (false);
                return false;
        }
    }

    private int getPrice(MenuType menu) {
        switch (menu) {
            case HOUSE_PIZZA:
                return HOUSE_PIZZA_PRICE;
            case MEAT_LOVER_PIZZA:
                return MEAT_LOVER_PIZZA_PRICE;
            case VEGGIE_PIZZA:
                return VEGGIE_PIZZA_PRICE;
            case FREE_SOUL_PIZZA:
                return FREE_SOUL_PIZZA_PRICE;
            case NO_HEAVY_MEAL:
                return NO_HEAVY_MEAL_PRICE;
            case THREE_COURSE_MEAL:
                return THREE_COURSE_MEAL_PRICE;
            case DEATH_BY_DESSERTS:
                return DEATH_BY_DESSERTS_PRICE;
            default:
                assert (false);
                return -1;
        }
    }
}
