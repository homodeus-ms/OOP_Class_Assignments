package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class Pizza extends Menu {
    private static final int HOUSE_PIZZA_MAX_MEAT_COUNT = 2;
    private static final int VEGGIE_PIZZA_MAX_CHEESE_COUNT = 2;
    private static final int MEAT_LOVER_PIZZA_MAX_VEGGIE_COUNT = 1;
    protected static final int FREE_SOUL_PIZZA_MAX_MEAT_COUNT = 2;
    protected static final int FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT = 2;
    protected static final int FREE_SOUL_PIZZA_MAX_CHEESE_COUNT = 1;

    private final ArrayList<Topping> toppings;
    private final PizzaType pizzaType;
    private int meatCount;
    private int veggieCount;
    private int cheeseCount;

    protected Pizza(PizzaType pizzaType, ArrayList<Topping> toppings) {
        super(getPrice(pizzaType));
        this.pizzaType = pizzaType;
        this.toppings = toppings;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    protected boolean addTopping(Topping topping) {
        if (isValid()) {
            return false;
        }

        ToppingType toppingType = getToppingType(topping);

        if (this.pizzaType == PizzaType.FREE_SOUL_PIZZA) {
            if ((toppingType == ToppingType.MEAT && meatCount >= FREE_SOUL_PIZZA_MAX_MEAT_COUNT)
                    || (toppingType == ToppingType.VEGGIE && veggieCount >= FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT)
                    || (toppingType == ToppingType.CHEESE && cheeseCount >= FREE_SOUL_PIZZA_MAX_CHEESE_COUNT)) {
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

    protected boolean removeTopping(Topping topping) {
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


    /*protected boolean addMeat(Topping topping) {
        if (isValid()) {
            return false;
        }
        this.toppings.add(topping);
        ++meatCount;
        return true;
    }
    protected boolean removeMeat(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);
        if (isRemoved) {
            --meatCount;
        }
        return isRemoved;
    }

    protected boolean addVeggie(Topping topping) {
        if (isValid()) {
            return false;
        }
        this.toppings.add(topping);
        ++veggieCount;
        return true;
    }
    protected boolean removeVeggie(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);
        if (isRemoved) {
            --veggieCount;
        }
        return isRemoved;
    }

    protected boolean addCheese(Topping topping) {
        if (isValid()) {
            return false;
        }
        this.toppings.add(topping);
        ++cheeseCount;
        return true;
    }
    protected boolean removeCheese(Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);
        if (isRemoved) {
            --cheeseCount;
        }
        return isRemoved;
    }*/

    public boolean isValid() {

        switch (pizzaType) {
            case HOUSE_PIZZA:
                return meatCount == HOUSE_PIZZA_MAX_MEAT_COUNT;
            case MEAT_LOVER_PIZZA:
                return veggieCount == MEAT_LOVER_PIZZA_MAX_VEGGIE_COUNT;
            case VEGGIE_PIZZA:
                return cheeseCount == VEGGIE_PIZZA_MAX_CHEESE_COUNT;
            case FREE_SOUL_PIZZA:
                return meatCount == FREE_SOUL_PIZZA_MAX_MEAT_COUNT &&
                        veggieCount == FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT
                        && cheeseCount == FREE_SOUL_PIZZA_MAX_CHEESE_COUNT;
            default:
                assert (false);
                return false;
        }
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
    private static int getPrice(PizzaType type) {
        switch (type) {
            case HOUSE_PIZZA:
                return HOUSE_PIZZA_PRICE;
            case MEAT_LOVER_PIZZA:
                return MEAT_LOVER_PIZZA_PRICE;
            case VEGGIE_PIZZA:
                return VEGGIE_PIZZA_PRICE;
            case FREE_SOUL_PIZZA:
                return FREE_SOUL_PIZZA_PRICE;
            default:
                assert (false);
                return -1;
        }
    }
}
