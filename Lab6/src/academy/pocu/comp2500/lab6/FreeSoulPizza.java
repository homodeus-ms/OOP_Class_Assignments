package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class FreeSoulPizza extends Pizza {
    private static final int MAX_MEAT_COUNT = 2;
    private static final int MAX_VEGGIE_COUNT = 2;
    private static final int MAX_CHEESE_COUNT = 1;

    public FreeSoulPizza() {
        super(new ArrayList<>(), FREE_SOUL_PIZZA_PRICE);
    }
    public boolean isValid() {
        return super.isPizzaValid(ToppingType.MEAT, MAX_MEAT_COUNT)
                && super.isPizzaValid(ToppingType.VEGGIE, MAX_VEGGIE_COUNT)
                && super.isPizzaValid(ToppingType.CHEESE, MAX_CHEESE_COUNT);
    }
    public boolean addTopping(Topping topping) {
        switch (topping.getToppingType()) {
            case MEAT:
                return addMeat(topping, MAX_MEAT_COUNT);
            case VEGGIE:
                return addVeggie(topping, MAX_VEGGIE_COUNT);
            case CHEESE:
                return addCheese(topping, MAX_CHEESE_COUNT);
            default:
                assert (false);
                return false;
        }
    }
    public boolean removeTopping(Topping topping) {
        switch (topping.getToppingType()) {
            case MEAT:
                return removeMeat(topping);
            case VEGGIE:
                return removeVeggie(topping);
            case CHEESE:
                return removeCheese(topping);
            default:
                assert (false);
                return false;
        }
    }
}
