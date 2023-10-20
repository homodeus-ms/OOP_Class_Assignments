package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Combo extends Menu {

    protected Combo(MenuType menu) {
        super(menu);
    }

    public ArrayList<Appetizer> getAppetizers() {
        if (menu == MenuType.THREE_COURSE_MEAL && appetizers.isEmpty()) {
            assert (false) : "call isValid() first!";
        }
        return appetizers;
    }
    public ArrayList<MainCourse> getMainCourses() {
        if (menu == MenuType.THREE_COURSE_MEAL && mainCourses.isEmpty()) {
            assert (false) : "call isValid() first!";
        }
        return mainCourses;
    }
    public ArrayList<Dessert> getDesserts() {
        if (menu != MenuType.DEATH_BY_DESSERTS && desserts.isEmpty()) {
            assert (false) : "call isValid() first!";
        }
        return desserts;
    }
}
