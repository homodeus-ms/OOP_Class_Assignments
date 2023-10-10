package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class Pizza extends Menu {
    protected static final int HOUSE_PIZZA_MAX_MEAT_COUNT = 2;
    protected static final int VEGGIE_PIZZA_MAX_CHEESE_COUNT = 2;
    protected static final int MEAT_LOVER_PIZZA_MAX_VEGGIE_COUNT = 1;
    protected static final int FREE_SOUL_PIZZA_MAX_MEAT_COUNT = 2;
    protected static final int FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT = 2;
    protected static final int FREE_SOUL_PIZZA_MAX_CHEESE_COUNT = 1;

    protected final ArrayList<Topping> toppings;
    protected final PizzaType pizzaType;
    protected int meatCount;
    protected int veggieCount;
    protected int cheeseCount;

    public enum PizzaType {
        HOUSE_PIZZA(HOUSE_PIZZA_PRICE),
        MEAT_LOVER_PIZZA(MEAT_LOVER_PIZZA_PRICE),
        VEGGIE_PIZZA(VEGGIE_PIZZA_PRICE),
        FREE_SOUL_PIZZA(FREE_SOUL_PIZZA_PRICE);

        private final int price;

        PizzaType(int price) {
            this.price = price;
        }
    }

    protected Pizza(PizzaType pizzaType, ArrayList<Topping> toppings) {
        super(pizzaType.price);
        this.pizzaType = pizzaType;
        this.toppings = toppings;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    protected boolean addToppingToPizza(Topping topping, ToppingType toppingtype) {
        if (isValid()) {
            return false;
        }

        this.toppings.add(topping);

        toppings.add(topping);

        switch (toppingtype) {
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
    protected boolean removeToppingFromPizza(Topping topping, ToppingType toppingType) {
        boolean isRemoved = toppings.remove(topping);

        if (isRemoved) {
            switch (topping.getToppingType()) {
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
                return meatCount == FREE_SOUL_PIZZA_MAX_MEAT_COUNT && veggieCount == FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT
                        && cheeseCount == FREE_SOUL_PIZZA_MAX_CHEESE_COUNT;
            default:
                assert (false);
                return false;
        }
    }

}
