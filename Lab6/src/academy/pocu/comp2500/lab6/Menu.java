package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Menu {
    /*protected static final int HOUSE_PIZZA_PRICE = 20;
    protected static final int MEAT_LOVER_PIZZA_PRICE = 21;
    protected static final int VEGGIE_PIZZA_PRICE = 17;
    protected static final int FREE_SOUL_PIZZA_PRICE = 25;
    protected static final int NO_HEAVY_MEAL_PRICE = 15;
    protected static final int THREE_COURSE_MEAL_PRICE = 25;
    protected static final int DEATH_BY_DESSERTS_PRICE = 20;*/
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

    /*protected int appetizerCount;
    protected int mainCourseCount;
    protected int dessertCount;*/

    protected int meatCount;
    protected int veggieCount;
    protected int cheeseCount;

    protected final ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected final ArrayList<MainCourse> mainCourse = new ArrayList<>();
    protected final ArrayList<Dessert> desserts = new ArrayList<>();

    protected Menu(FoodType foodType) {
        this.foodType = foodType;
    }


    public int getPrice() {
        return foodType.price;
    }

    // noHeavyMeal : getAppetizer는 언제나 됨, Dessert는? (널체크를 함)
    // ThreeCourse : ArrayList를 안쓰기때문에 다 널체크를 함
    // deathByDessert : 널체크를 안함
    public ArrayList<Appetizer> getAppetizers() {
        assert (isValid());
        return appetizers;
    }
    public ArrayList<MainCourse> getMainCourse() {
        assert (isValid());
        return mainCourse;
    }
    public ArrayList<Dessert> getDesserts() {
        assert (isValid());
        return desserts;
    }




    public boolean isValid() {
        switch (foodType) {
            case NO_HEAVY_MEAL:
                return appetizers.size() == 2 && desserts.size() == 1;
            case THREE_COURSE_MEAL:
                return appetizers.size() == 1 && !mainCourse.isEmpty() && desserts.size() == 1;
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
