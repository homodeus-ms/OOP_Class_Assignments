package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(PizzaType.HOUSE_PIZZA, new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE)));
    }

    public boolean addBacon() {
        return addToppingToPizza(Topping.BACON, ToppingType.MEAT);
    }
    public boolean removeBacon() {
        return removeToppingFromPizza(Topping.BACON, ToppingType.MEAT);
    }
    public boolean addPeperoni() {
        return addToppingToPizza(Topping.PEPERONI, ToppingType.MEAT);
    }
    public boolean removePeperoni() {
        return removeToppingFromPizza(Topping.PEPERONI, ToppingType.MEAT);
    }
    public boolean addSausages() {
        return addToppingToPizza(Topping.SAUSAGES, ToppingType.MEAT);
    }
    public boolean removeSausages() {
        return removeToppingFromPizza(Topping.SAUSAGES, ToppingType.MEAT);
    }
}
