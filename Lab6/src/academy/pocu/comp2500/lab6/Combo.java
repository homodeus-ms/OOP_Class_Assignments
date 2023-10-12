package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
public class Combo extends Menu {

    protected Combo(FoodType foodType) {
        super(foodType);
    }

    public ArrayList<Appetizer> getAppetizers() {
        assert (isValid());
        return appetizers;
    }
    public ArrayList<Dessert> getDesserts() {
        assert (isValid());
        return desserts;
    }

}
