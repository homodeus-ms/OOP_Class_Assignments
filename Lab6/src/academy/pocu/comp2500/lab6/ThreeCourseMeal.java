package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Combo {

    public ThreeCourseMeal() {
        super(FoodType.THREE_COURSE_MEAL);
    }

    public Appetizer getAppetizer() {
        assert (isValid()) : "set appetizer first";
        return appetizers.get(0);
    }
    public MainCourse getMainCourse() {
        assert (isValid()) : "set mainCourse first";
        return mainCourse.get(0);
    }
    public Dessert getDessert() {
        assert (isValid()) : "set dessert first";
        return desserts.get(0);
    }

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
