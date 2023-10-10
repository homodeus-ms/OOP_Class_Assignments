package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Menu {
    protected final ArrayList<Topping> toppings;
    protected int meatCount;
    protected int veggieCount;
    protected int cheeseCount;

    protected Pizza(ArrayList<Topping> toppings, int price) {
        super(price);
        this.toppings = toppings;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    protected boolean addMeat(Topping topping, int maxCount) {
        if (isPizzaValid(ToppingType.MEAT, maxCount)) {
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

    protected boolean addVeggie(Topping topping, int maxCount) {
        if (isPizzaValid(ToppingType.VEGGIE, maxCount)) {
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

    protected boolean addCheese(Topping topping, int maxCount) {
        if (isPizzaValid(ToppingType.CHEESE, maxCount)) {
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
    }

    protected boolean isPizzaValid(ToppingType toppingType, int maxCount) {
        switch (toppingType) {
            case MEAT:
                return meatCount == maxCount;
            case VEGGIE:
                return veggieCount == maxCount;
            case CHEESE:
                return cheeseCount == maxCount;
            default:
                assert (false);
                return false;
        }
    }
}
