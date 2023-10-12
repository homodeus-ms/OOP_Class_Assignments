package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
public class Combo extends Menu {

    protected Combo(FoodType foodType) {
        super(foodType);
    }

    public ArrayList<Appetizer> getAppetizersOrNull() {
        if (foodType == FoodType.DEATH_BY_DESSERTS || (foodType == FoodType.THREE_COURSE_MEAL && !isValid())) {
            return null;
        }
        return appetizers;
    }
    public ArrayList<Dessert> getDessertsOrNull() {
        if (foodType != FoodType.DEATH_BY_DESSERTS && !isValid()) {
            return null;
        }
        return desserts;
    }
    public MainCourse getMainCourseOrNull() {
        if (foodType != FoodType.THREE_COURSE_MEAL || !isValid()) {
            return null;
        }
        return super.mainCourse;
    }

}
