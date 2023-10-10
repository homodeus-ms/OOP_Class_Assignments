package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class MeatLoverPizza extends Pizza {

    public MeatLoverPizza() {
        super(FoodType.MEAT_LOVER_PIZZA, new ArrayList<>(Arrays.asList(Topping.BACON, Topping.PEPERONI, Topping.HAM,
                Topping.SAUSAGES, Topping.CHEDDAR_CHEESE)));
    }

    public boolean addBlackOlives() {
        return addToppingToPizza(Topping.BLACK_OLIVES);
    }
    public boolean removeBlackOlives() {
        return removeToppingFromPizza(Topping.BLACK_OLIVES);
    }
    public boolean addRedOnions() {
        return addToppingToPizza(Topping.RED_ONIONS);
    }
    public boolean removeRedOnions() {
        return removeToppingFromPizza(Topping.RED_ONIONS);
    }
    public boolean addGreenPeppers() {
        return addToppingToPizza(Topping.GREEN_PEPPERS);
    }
    public boolean removeGreenPeppers() {
        return removeToppingFromPizza(Topping.GREEN_PEPPERS);
    }

}
