package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class FreeSoulPizza extends Pizza {

    public FreeSoulPizza() {
        super(FoodType.FREE_SOUL_PIZZA, new ArrayList<>());
    }

    public boolean addTopping(Topping topping) {
        return super.addToppingToPizza(topping);
    }
    public boolean removeTopping(Topping topping) {
        return super.removeToppingFromPizza(topping);
    }

}
