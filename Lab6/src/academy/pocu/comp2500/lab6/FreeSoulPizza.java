package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class FreeSoulPizza extends Pizza {

    public FreeSoulPizza() {
        super(MenuType.FREE_SOUL_PIZZA, new ArrayList<>(5));
    }
    public boolean addTopping(Topping topping) {
        ToppingType toppingType = getToppingType(topping);

        if ((toppingType == ToppingType.MEAT && addedMeatCount >= FREE_PIZZA_MAX_MEAT_COUNT) ||
                (toppingType == ToppingType.VEGGIE && addedVeggieCount >= FREE_PIZZA_MAX_VEGGIE_COUNT)
                || (toppingType == ToppingType.CHEESE && addedCheeseCount >= FREE_PIZZA_MAX_CHEESE_COUNT)) {
            return false;
        }

        return addToppingToPizza(topping);
    }
    public boolean removeTopping(Topping topping) {
        return removeToppingFromPizza(topping);
    }
}
