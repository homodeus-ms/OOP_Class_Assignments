package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {

    public ThreeCourseMeal() {
        super(MenuType.THREE_COURSE_MEAL);
    }

    public void setMainCourse(MainCourse mainCourse) {
        mainCourses.clear();
        mainCourses.add(mainCourse);
    }
    public void setAppetizer(Appetizer appetizer) {
        appetizers.clear();
        appetizers.add(appetizer);
    }
    public void setDessert(Dessert dessert) {
        desserts.clear();
        desserts.add(dessert);
    }
}
