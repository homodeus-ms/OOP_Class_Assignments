package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {
    private static final int APPETIZER_COUNT = 1;
    private static final int DESSERT_COUNT = 1;

    public ThreeCourseMeal() {
        super(THREE_COURSE_MEAL_PRICE);
    }
    public boolean isValid() {
        return appetizers.size() == APPETIZER_COUNT && mainCourse != null &&
                desserts.size() == DESSERT_COUNT;
    }
    public void setAppetizer(Appetizer appetizer) {
        super.appetizers.clear();
        appetizers.add(appetizer);
    }
    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourse = mainCourse;
    }
    public void setDessert(Dessert dessert) {
        super.desserts.clear();
        desserts.add(dessert);
    }
}
