package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(PizzaType.HOUSE_PIZZA, new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE)));
    }

    public boolean addBacon() {
        return addToppingToPizza(Topping.BACON);
    }
    public boolean removeBacon() {
        return removeToppingFromPizza(Topping.BACON);
    }
    public boolean addPeperoni() {
        return addToppingToPizza(Topping.PEPERONI);
    }
    public boolean removePeperoni() {
        return removeToppingFromPizza(Topping.PEPERONI);
    }
    public boolean addSausages() {
        return addToppingToPizza(Topping.SAUSAGES);
    }
    public boolean removeSausages() {
        return removeToppingFromPizza(Topping.SAUSAGES);
    }
}
