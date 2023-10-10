package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(PizzaType.HOUSE_PIZZA, new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE)));
    }

    public boolean addBacon() {
        return addTopping(Topping.BACON);
    }
    public boolean removeBacon() {
        return removeTopping(Topping.BACON);
    }
    public boolean addPeperoni() {
        return addTopping(Topping.PEPERONI);
    }
    public boolean removePeperoni() {
        return removeTopping(Topping.PEPERONI);
    }
    public boolean addSausages() {
        return addTopping(Topping.SAUSAGES);
    }
    public boolean removeSausages() {
        return removeTopping(Topping.SAUSAGES);
    }
}
