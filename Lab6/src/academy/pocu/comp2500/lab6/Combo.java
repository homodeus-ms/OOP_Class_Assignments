package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
public class Combo extends Menu {

    protected Combo(FoodType foodType) {
        super(foodType);
    }

    public ArrayList<Appetizer> getAppetizers() {
        if (foodType == FoodType.DEATH_BY_DESSERTS || (foodType == FoodType.THREE_COURSE_MEAL && !isValid())) {
            assert (false);
        }
        return appetizers;
    }
    public ArrayList<Dessert> getDesserts() {
        if (foodType != FoodType.DEATH_BY_DESSERTS && !isValid()) {
            assert (false);
        }
        return desserts;
    }
    public MainCourse getMainCourse() {
        if (foodType != FoodType.THREE_COURSE_MEAL || !isValid()) {
            assert (false);
        }
        return super.mainCourse;
    }

}
