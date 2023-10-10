package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(PizzaType.VEGGIE_PIZZA, new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                Topping.GREEN_PEPPERS)));
    }

    public boolean addMozzarellaCheese() {
        return addTopping(Topping.MOZZARELLA_CHEESE);
    }
    public boolean removeMozzarellaCheese() {
        return removeTopping(Topping.MOZZARELLA_CHEESE);
    }
    public boolean addCheddarCheese() {
        return addTopping(Topping.CHEDDAR_CHEESE);
    }
    public boolean removeCheddarCheese() {
        return removeTopping(Topping.CHEDDAR_CHEESE);
    }
    public boolean addFetaCheese() {
        return addTopping(Topping.FETA_CHEESE);
    }
    public boolean removeFetaCheese() {
        return removeTopping(Topping.FETA_CHEESE);
    }

}
