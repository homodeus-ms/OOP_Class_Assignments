package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {

    private MainCourse mainCourse;
    public ThreeCourseMeal() {
        super(FoodType.THREE_COURSE_MEAL);
    }

    public MainCourse getMainCourse() {
        assert (mainCourse != null) : "set MainCourse first";
        return this.mainCourse;
    }

    public void setAppetizer(Appetizer appetizer) {
        super.appetizers.clear();
        appetizers.add(appetizer);
    }
    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
        super.setMainCourse();
    }
    public void setDessert(Dessert dessert) {
        super.desserts.clear();
        desserts.add(dessert);
    }
}
