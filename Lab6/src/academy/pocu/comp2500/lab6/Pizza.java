package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Menu {

    protected ArrayList<Topping> toppings;

    protected Pizza(FoodType foodType, ArrayList<Topping> toppings) {
        super(foodType);
        this.toppings = toppings;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    protected boolean addToppingToPizza(Topping topping) {
        if (isValid()) {
            return false;
        }

        ToppingType toppingType = getToppingType(topping);

        if (foodType == FoodType.FREE_SOUL_PIZZA) {
            if ((toppingType == ToppingType.MEAT && meatCount >= 2)
                    || (toppingType == ToppingType.VEGGIE && veggieCount >= 2)
                    || (toppingType == ToppingType.CHEESE && cheeseCount >= 1)) {
                return false;
            }
        }

        toppings.add(topping);

        switch (toppingType) {
            case MEAT:
                ++meatCount;
                break;
            case VEGGIE:
                ++veggieCount;
                break;
            case CHEESE:
                ++cheeseCount;
                break;
            default:
                assert (false);
                break;
        }
        return true;
    }

    protected boolean removeToppingFromPizza(Topping topping) {
        boolean isRemoved = toppings.remove(topping);

        if (isRemoved) {
            switch (getToppingType(topping)) {
                case MEAT:
                    --meatCount;
                    break;
                case VEGGIE:
                    --veggieCount;
                    break;
                case CHEESE:
                    --cheeseCount;
                    break;
                default:
                    assert (false);
                    break;
            }
        }
        return isRemoved;
    }

    private ToppingType getToppingType(Topping topping) {
        if (topping == Topping.BACON || topping == Topping.CHICKEN || topping == Topping.SAUSAGES ||
                topping == Topping.HAM || topping == Topping.PEPERONI) {
            return ToppingType.MEAT;
        } else if (topping == Topping.BLACK_OLIVES || topping == Topping.GREEN_PEPPERS ||
                topping == Topping.RED_ONIONS) {
            return ToppingType.VEGGIE;
        } else {
            return ToppingType.CHEESE;
        }
    }
}
