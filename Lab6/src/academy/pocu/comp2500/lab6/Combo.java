package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Combo extends Menu {
    protected static final int MAX_APPETIZER_COUNT = 2;
    protected static final int MAX_DESSERT_COUNT = 4;

    protected final ArrayList<Appetizer> appetizers = new ArrayList<>(MAX_APPETIZER_COUNT);
    protected MainCourse mainCourse = null;
    protected final ArrayList<Dessert> desserts = new ArrayList<>(MAX_DESSERT_COUNT);

    protected Combo(int price) {
        super(price);
    }
    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }
    public MainCourse getMainCourseOrNull() {
        return this.mainCourse;
    }
    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

}
