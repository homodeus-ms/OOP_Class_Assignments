package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {

    public ThreeCourseMeal() {
        super(FoodType.THREE_COURSE_MEAL);
    }

    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourse = mainCourse;
    }

    public void setAppetizer(Appetizer appetizer) {
        appetizers.set(0, appetizer);
        //appetizerCount = 1;
    }

    public void setDessert(Dessert dessert) {
        desserts.set(0, dessert);
        //dessertCount = 1;
    }

    public MainCourse getMainCourse() {
        assert (isValid());
        return super.mainCourse;
    }
    /*public Appetizer getAppetizerOrNull() {
        return isValid() ? appetizers.get(0) : null;
    }
    public MainCourse getMainCourseOrNull() {
        return isValid() ? mainCourse.get(0) : null;
    }
    public Dessert getDessertOrNull() {
        return isValid() ? desserts.get(0) : null;
    }*/
}
