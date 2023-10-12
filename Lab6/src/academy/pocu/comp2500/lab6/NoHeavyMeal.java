package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends Combo {

    public static final int MAX_APPETIZER_COUNT = 2;
    public static final int MAX_DESSERT_COUNT = 1;

    public NoHeavyMeal() {
        super(FoodType.NO_HEAVY_MEAL);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        super.appetizers.clear();
        appetizers.add(appetizer1);
        appetizers.add(appetizer2);
    }
    public void setDessert(Dessert dessert) {
        desserts.clear();
        desserts.add(dessert);
    }
}
