package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Combo extends Menu {
    protected static final int MAX_APPETIZER_COUNT = 2;
    protected static final int MAX_DESSERT_COUNT = 4;

    protected final ArrayList<Appetizer> appetizers = new ArrayList<>(MAX_APPETIZER_COUNT);
    protected final ArrayList<MainCourse> mainCourse = new ArrayList<>(1);
    protected final ArrayList<Dessert> desserts = new ArrayList<>(MAX_DESSERT_COUNT);

    protected Combo(FoodType foodType) {
        super(foodType);
    }

    public ArrayList<Appetizer> getCombosAppetizers() {
        return this.appetizers;
    }
    public ArrayList<MainCourse> getMainCourseOrNull() {
        return this.mainCourse;
    }
    public ArrayList<Dessert> getCombosDesserts() {
        return this.desserts;
    }

    /*protected void setMainCourse() {
        this.isMainCourseExist = true;
    }*/

    public boolean isValid() {
        switch (foodType) {
            case NO_HEAVY_MEAL:
                return appetizers.size() == 2 && desserts.size() == 1;
            case THREE_COURSE_MEAL:
                return appetizers.size() == 1 && !mainCourse.isEmpty() && desserts.size() == 1;
            case DEATH_BY_DESSERTS:
                return desserts.size() == 4;
            default:
                assert (false);
                return false;
        }
    }
}
