package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(MenuType.VEGGIE_PIZZA, new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES,
                Topping.RED_ONIONS, Topping.GREEN_PEPPERS)));
    }
    public boolean addMozzarellaCheese() {
        return addToppingToPizza(Topping.MOZZARELLA_CHEESE);
    }
    public boolean removeMozzarellaCheese() {
        return removeToppingFromPizza(Topping.MOZZARELLA_CHEESE);
    }
    public boolean addCheddarCheese() {
        return addToppingToPizza(Topping.CHEDDAR_CHEESE);
    }
    public boolean removeCheddarCheese() {
        return removeToppingFromPizza(Topping.CHEDDAR_CHEESE);
    }
    public boolean addFetaCheese() {
        return addToppingToPizza(Topping.FETA_CHEESE);
    }
    public boolean removeFetaCheese() {
        return removeToppingFromPizza(Topping.FETA_CHEESE);
    }
}
