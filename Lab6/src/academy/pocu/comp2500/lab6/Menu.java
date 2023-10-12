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

    protected final FoodType foodType;
    protected int meatCount;
    protected int veggieCount;
    protected int cheeseCount;

    protected final ArrayList<Appetizer> appetizers = new ArrayList<>(NoHeavyMeal.MAX_APPETIZER_COUNT);
    protected final ArrayList<MainCourse> mainCourses = new ArrayList<>(1);
    protected final ArrayList<Dessert> desserts = new ArrayList<>(4);

    protected Menu(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getPrice() {
        return foodType.price;
    }

    public boolean isValid() {
        switch (foodType) {
            case NO_HEAVY_MEAL:
                return appetizers.size() == NoHeavyMeal.MAX_APPETIZER_COUNT &&
                        desserts.size() == NoHeavyMeal.MAX_DESSERT_COUNT;
            case THREE_COURSE_MEAL:
                return appetizers.size() == 1 && !mainCourses.isEmpty() && desserts.size() == 1;
            case DEATH_BY_DESSERTS:
                return desserts.size() == 4;
            case HOUSE_PIZZA:
                return meatCount == 2;
            case MEAT_LOVER_PIZZA:
                return veggieCount == 1;
            case VEGGIE_PIZZA:
                return cheeseCount == 2;
            case FREE_SOUL_PIZZA:
                return meatCount == 2 &&
                        veggieCount == 2
                        && cheeseCount == 1;
            default:
                assert (false);
                return false;
        }
    }
}
