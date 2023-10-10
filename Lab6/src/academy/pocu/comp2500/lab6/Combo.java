package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Combo extends Menu {
    protected static final int MAX_APPETIZER_COUNT = 2;
    protected static final int MAX_DESSERT_COUNT = 4;

    protected final ArrayList<Appetizer> appetizers = new ArrayList<>(MAX_APPETIZER_COUNT);
    protected ArrayList<MainCourse> mainCourses = new ArrayList<>(1);
    protected final ArrayList<Dessert> desserts = new ArrayList<>(MAX_DESSERT_COUNT);

    protected Combo(FoodType foodType) {
        super(foodType);

    }
    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }
    public ArrayList<MainCourse> getMainCourse() {
        return this.mainCourses;
    }
    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

    public boolean isValid() {
        switch (foodType) {
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
}
