package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class MeatLoverPizza extends Pizza {

    public MeatLoverPizza() {
        super(PizzaType.MEAT_LOVER_PIZZA, new ArrayList<>(Arrays.asList(Topping.BACON, Topping.PEPERONI, Topping.HAM,
                Topping.SAUSAGES, Topping.CHEDDAR_CHEESE)));
    }

    public boolean addBlackOlives() {
        return addTopping(Topping.BLACK_OLIVES);
    }
    public boolean removeBlackOlives() {
        return removeTopping(Topping.BLACK_OLIVES);
    }
    public boolean addRedOnions() {
        return addTopping(Topping.RED_ONIONS);
    }
    public boolean removeRedOnions() {
        return removeTopping(Topping.RED_ONIONS);
    }
    public boolean addGreenPeppers() {
        return addTopping(Topping.GREEN_PEPPERS);
    }
    public boolean removeGreenPeppers() {
        return removeTopping(Topping.GREEN_PEPPERS);
    }

}
