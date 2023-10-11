package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {

    public ThreeCourseMeal() {
        super(FoodType.THREE_COURSE_MEAL);
    }

    /*public MainCourse getMainCourse() {
        assert (mainCourse != null) : "set MainCourse first";
        return this.mainCourse;
    }*/

    public void setAppetizer(Appetizer appetizer) {
        super.appetizers.clear();
        appetizers.add(appetizer);
    }
    public void setMainCourse(MainCourse mainCourse) {
        super.mainCourse.clear();
        super.mainCourse.add(mainCourse);
    }
    public void setDessert(Dessert dessert) {
        super.desserts.clear();
        desserts.add(dessert);
    }
}
