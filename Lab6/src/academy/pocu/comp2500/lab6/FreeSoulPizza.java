package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class FreeSoulPizza extends Pizza {

    public FreeSoulPizza() {
        super(PizzaType.FREE_SOUL_PIZZA, new ArrayList<>());
    }

    public boolean addTopping(Topping topping) {
        ToppingType toppingType = topping.getToppingType();

        if (toppingType == ToppingType.MEAT && this.meatCount >= FREE_SOUL_PIZZA_MAX_MEAT_COUNT
                || toppingType == ToppingType.VEGGIE && veggieCount >= FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT
                || toppingType == ToppingType.CHEESE && cheeseCount >= FREE_SOUL_PIZZA_MAX_CHEESE_COUNT) {
            return false;
        }
        return addToppingToPizza(topping, toppingType);
    }
    public boolean removeTopping(Topping topping) {
        return removeToppingFromPizza(topping, topping.getToppingType());
    }

}
