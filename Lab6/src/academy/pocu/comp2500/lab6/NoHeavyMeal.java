package academy.pocu.comp2500.lab6;

public class NoHeavyMeal extends Combo {

    public NoHeavyMeal() {
        super(MenuType.NO_HEAVY_MEAL);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        appetizers.clear();
        appetizers.add(appetizer1);
        appetizers.add(appetizer2);
    }
    public void setDessert(Dessert dessert) {
        desserts.clear();
        desserts.add(dessert);
    }
}
