package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class VeggiePizza extends Pizza {
    private static final int MAX_CHEESE_COUNT = 2;

    public VeggiePizza() {
        super(new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                Topping.GREEN_PEPPERS)), VEGGIE_PIZZA_PRICE);
    }
    public boolean isValid() {
        return super.isValid(ToppingType.CHEESE, MAX_CHEESE_COUNT);
    }
    public boolean addMozzarellaCheese() {
        return addCheese(Topping.MOZZARELLA_CHEESE, MAX_CHEESE_COUNT);
    }
    public boolean removeMozzarellaCheese() {
        return removeCheese(Topping.MOZZARELLA_CHEESE);
    }
    public boolean addCheddarCheese() {
        return addCheese(Topping.CHEDDAR_CHEESE, MAX_CHEESE_COUNT);
    }
    public boolean removeCheddarCheese() {
        return removeCheese(Topping.CHEDDAR_CHEESE);
    }
    public boolean addFetaCheese() {
        return addCheese(Topping.FETA_CHEESE, MAX_CHEESE_COUNT);
    }
    public boolean removeFetaCheese() {
        return removeCheese(Topping.FETA_CHEESE);
    }
}
