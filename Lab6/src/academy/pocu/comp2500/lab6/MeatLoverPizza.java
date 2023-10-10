package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class MeatLoverPizza extends Pizza {
    private static final int MAX_VEGGIE_COUNT = 1;

    public MeatLoverPizza() {
        super(new ArrayList<>(Arrays.asList(Topping.BACON, Topping.PEPERONI, Topping.HAM,
                Topping.SAUSAGES, Topping.CHEDDAR_CHEESE)), MEAT_LOVER_PIZZA_PRICE);
    }
    public boolean isValid() {
        return super.isPizzaValid(ToppingType.VEGGIE, MAX_VEGGIE_COUNT);
    }
    public boolean addBlackOlives() {
        return addVeggie(Topping.BLACK_OLIVES, MAX_VEGGIE_COUNT);
    }
    public boolean removeBlackOlives() {
        return removeVeggie(Topping.BLACK_OLIVES);
    }
    public boolean addRedOnions() {
        return addVeggie(Topping.RED_ONIONS, MAX_VEGGIE_COUNT);
    }
    public boolean removeRedOnions() {
        return removeVeggie(Topping.RED_ONIONS);
    }
    public boolean addGreenPeppers() {
        return addVeggie(Topping.GREEN_PEPPERS, MAX_VEGGIE_COUNT);
    }
    public boolean removeGreenPeppers() {
        return removeVeggie(Topping.GREEN_PEPPERS);
    }
}
