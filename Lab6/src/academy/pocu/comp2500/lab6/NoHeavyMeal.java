package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends Combo {

    private static final int DESSERT_COUNT = 1;

    public NoHeavyMeal() {
        super(NO_HEAVY_MEAL_PRICE);
    }
    public boolean isValid() {
        return appetizers.size() == MAX_APPETIZER_COUNT && desserts.size() == DESSERT_COUNT && mainCourse == null;
    }
    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        super.appetizers.clear();
        appetizers.add(appetizer1);
        appetizers.add(appetizer2);
    }
    public void setDessert(Dessert dessert) {
        super.desserts.clear();
        desserts.add(dessert);
    }
}
