package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {

    public ThreeCourseMeal() {
        super(FoodType.THREE_COURSE_MEAL);
    }

    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourse.set(0, mainCourse);
        mainCourseCount = 1;
    }

    public void setAppetizer(Appetizer appetizer) {
        appetizers.set(0, appetizer);
        appetizerCount = 1;
    }

    public void setDessert(Dessert dessert) {
        desserts.set(0, dessert);
        dessertCount = 1;
    }
}
