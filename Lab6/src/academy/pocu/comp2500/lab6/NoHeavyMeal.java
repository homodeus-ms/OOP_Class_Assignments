package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class NoHeavyMeal extends Combo {

    public NoHeavyMeal() {
        super(FoodType.NO_HEAVY_MEAL);
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        super.appetizers.clear();
        appetizers.add(appetizer1);
        appetizers.add(appetizer2);
        //appetizerCount = 2;
    }
    public void setDessert(Dessert dessert) {
        desserts.set(0, dessert);
        //dessertCount = 1;
    }
    /*public ArrayList<Appetizer> getAppetizers() {
        return appetizers;
    }
    public Dessert getDessertOrNull() {
        return isValid() ? desserts.get(0) : null;
    }*/

}
