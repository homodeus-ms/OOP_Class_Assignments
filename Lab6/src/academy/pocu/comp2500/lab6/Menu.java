package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Menu {
    public enum FoodType {
        HOUSE_PIZZA(20),
        MEAT_LOVER_PIZZA(21),
        VEGGIE_PIZZA(17),
        FREE_SOUL_PIZZA(25),
        NO_HEAVY_MEAL(15),
        THREE_COURSE_MEAL(25),
        DEATH_BY_DESSERTS(20);

        private final int price;

        FoodType(int price) {
            this.price = price;
        }
    }

    private static final int NO_HEAVY_MEAL_APPETIZER_COUNT = 2;
    private static final int NO_HEAVY_MEAL_DESSERT_COUNT = 1;
    private static final int THREE_COURSE_MEAL_APPETIZER_COUNT = 1;
    private static final int THREE_COURSE_MEAL_MAIN_COURSE_COUNT = 1;
    private static final int THREE_COURSE_MEAL_DESSERT_COUNT = 1;
    private static final int DEATH_BY_DESSERT_DESSERT_COUNT = 4;

    private static final int HOUSE_PIZZA_MAX_MEAT_COUNT = 2;
    private static final int VEGGIE_PIZZA_MAX_CHEESE_COUNT = 2;
    private static final int MEAT_LOVER_PIZZA_MAX_VEGGIE_COUNT = 1;
    private static final int FREE_SOUL_PIZZA_MAX_MEAT_COUNT = 2;
    private static final int FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT = 2;
    private static final int FREE_SOUL_PIZZA_MAX_CHEESE_COUNT = 1;


    protected final FoodType foodType;
    protected int meatCount;
    protected int veggieCount;
    protected int cheeseCount;

    protected final ArrayList<Appetizer> appetizers = new ArrayList<>(NO_HEAVY_MEAL_APPETIZER_COUNT);
    protected final ArrayList<MainCourse> mainCourses = new ArrayList<>(THREE_COURSE_MEAL_MAIN_COURSE_COUNT);
    protected final ArrayList<Dessert> desserts = new ArrayList<>(DEATH_BY_DESSERT_DESSERT_COUNT);

    protected Menu(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getPrice() {
        return foodType.price;
    }

    public boolean isValid() {
        switch (foodType) {
            case NO_HEAVY_MEAL:
                return appetizers.size() == NO_HEAVY_MEAL_APPETIZER_COUNT &&
                        desserts.size() == NO_HEAVY_MEAL_DESSERT_COUNT;
            case THREE_COURSE_MEAL:
                return !appetizers.isEmpty() && !mainCourses.isEmpty() && !desserts.isEmpty();
            case DEATH_BY_DESSERTS:
                return desserts.size() == DEATH_BY_DESSERT_DESSERT_COUNT;
            case HOUSE_PIZZA:
                return meatCount == HOUSE_PIZZA_MAX_MEAT_COUNT;
            case MEAT_LOVER_PIZZA:
                return veggieCount == MEAT_LOVER_PIZZA_MAX_VEGGIE_COUNT;
            case VEGGIE_PIZZA:
                return cheeseCount == VEGGIE_PIZZA_MAX_CHEESE_COUNT;
            case FREE_SOUL_PIZZA:
                return meatCount == FREE_SOUL_PIZZA_MAX_MEAT_COUNT &&
                        veggieCount == FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT
                        && cheeseCount == FREE_SOUL_PIZZA_MAX_CHEESE_COUNT;
            default:
                assert (false);
                return false;
        }
    }
}
