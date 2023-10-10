package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class HousePizza extends Pizza {
    private static final int MAX_MEAT_COUNT = 2;

    public HousePizza() {
        super(new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE)), HOUSE_PIZZA_PRICE);
    }

    public boolean isValid() {
        return super.isValid(ToppingType.MEAT, MAX_MEAT_COUNT);
    }

    public boolean addBacon() {
        return addMeat(Topping.BACON, MAX_MEAT_COUNT);
    }
    public boolean removeBacon() {
        return removeMeat(Topping.BACON);
    }
    public boolean addPeperoni() {
        return addMeat(Topping.PEPERONI, MAX_MEAT_COUNT);
    }
    public boolean removePeperoni() {
        return removeMeat(Topping.PEPERONI);
    }
    public boolean addSausages() {
        return addMeat(Topping.SAUSAGES, MAX_MEAT_COUNT);
    }
    public boolean removeSausages() {
        return removeMeat(Topping.SAUSAGES);
    }
}
