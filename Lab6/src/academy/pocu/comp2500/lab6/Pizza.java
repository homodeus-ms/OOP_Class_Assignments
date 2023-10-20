package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Menu {

    protected enum ToppingType {
        MEAT,
        VEGGIE,
        CHEESE
    }

    private final ArrayList<Topping> toppings;

    protected Pizza(MenuType menu, ArrayList<Topping> toppings) {
        super(menu);
        this.toppings = toppings;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    protected boolean addToppingToPizza(Topping topping) {


        if (!isValid()) {
            ToppingType toppingType = getToppingType(topping);

            switch (toppingType) {
                case MEAT:
                    ++addedMeatCount;
                    break;
                case VEGGIE:
                    ++addedVeggieCount;
                    break;
                case CHEESE:
                    ++addedCheeseCount;
                    break;
                default:
                    assert (false);
                    break;
            }

            toppings.add(topping);

            return true;
        }
        return false;
    }
    protected boolean removeToppingFromPizza(Topping topping) {
        boolean isRemoved = toppings.remove(topping);
        if (isRemoved) {
            ToppingType toppingType = getToppingType(topping);

            switch (toppingType) {
                case MEAT:
                    --addedMeatCount;
                    break;
                case VEGGIE:
                    --addedVeggieCount;
                    break;
                case CHEESE:
                    --addedCheeseCount;
                    break;
                default:
                    assert (false);
                    break;
            }
            return true;
        }
        return false;
    }
    protected ToppingType getToppingType(Topping topping) {
        if (topping == Topping.BACON || topping == Topping.PEPERONI ||
                topping == Topping.SAUSAGES || topping == Topping.CHICKEN ||
                topping == Topping.HAM) {
            return ToppingType.MEAT;
        } else if (topping == Topping.BLACK_OLIVES || topping == Topping.RED_ONIONS ||
                topping == Topping.GREEN_PEPPERS) {
            return ToppingType.VEGGIE;
        } else {
            return ToppingType.CHEESE;
        }
    }
}
