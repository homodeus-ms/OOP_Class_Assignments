package academy.pocu.comp2500.lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class Pizza extends Menu {
    /*protected static final int HOUSE_PIZZA_MAX_MEAT_COUNT = 2;
    protected static final int VEGGIE_PIZZA_MAX_CHEESE_COUNT = 2;
    protected static final int MEAT_LOVER_PIZZA_MAX_VEGGIE_COUNT = 1;
    protected static final int FREE_SOUL_PIZZA_MAX_MEAT_COUNT = 2;
    protected static final int FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT = 2;
    protected static final int FREE_SOUL_PIZZA_MAX_CHEESE_COUNT = 1;*/

    protected final ArrayList<Topping> toppings;
    protected final PizzaType pizzaType;
    protected int meatCount;
    protected int veggieCount;
    protected int cheeseCount;

    public enum PizzaType {
        HOUSE_PIZZA(2, 0, 0, HOUSE_PIZZA_PRICE),
        MEAT_LOVER_PIZZA(0, 1, 0, MEAT_LOVER_PIZZA_PRICE),
        VEGGIE_PIZZA(0, 0, 2, VEGGIE_PIZZA_PRICE),
        FREE_SOUL_PIZZA(2, 2, 1, FREE_SOUL_PIZZA_PRICE);

        private final int maxMeatCount;
        private final int maxVeggieCount;
        private final int maxCheeseCount;
        private final int price;

        PizzaType(int maxMeatCount, int maxVeggieCount, int maxCheeseCount, int price) {
            this.maxMeatCount = maxMeatCount;
            this.maxVeggieCount = maxVeggieCount;
            this.maxCheeseCount = maxCheeseCount;
            this.price = price;
        }
    }

    protected Pizza(PizzaType pizzaType) {
        super(pizzaType.price);
        this.pizzaType = pizzaType;
        this.toppings = setPizza(pizzaType);
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }


    protected boolean addToppingToPizza(Topping topping) {

        ToppingType toppingType = topping.getToppingType();

        if (toppingType == ToppingType.MEAT && this.meatCount >= this.pizzaType.maxMeatCount
                || toppingType == ToppingType.VEGGIE && this.veggieCount >= this.pizzaType.maxVeggieCount
                || toppingType == ToppingType.CHEESE && this.cheeseCount >= this.pizzaType.maxCheeseCount) {
            return false;
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

    public boolean addBlackOlives() {
        return addToppingToPizza(Topping.BLACK_OLIVES);
    }
    public boolean removeBlackOlives() {
        return removeToppingFromPizza(Topping.BLACK_OLIVES);
    }
    public boolean addRedOnions() {
        return addToppingToPizza(Topping.RED_ONIONS);
    }
    public boolean removeRedOnions() {
        return removeToppingFromPizza(Topping.RED_ONIONS);
    }
    public boolean addGreenPeppers() {
        return addToppingToPizza(Topping.GREEN_PEPPERS);
    }
    public boolean removeGreenPeppers() {
        return removeToppingFromPizza(Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        return addToppingToPizza(Topping.MOZZARELLA_CHEESE);
    }
    public boolean removeMozzarellaCheese() {
        return removeToppingFromPizza(Topping.MOZZARELLA_CHEESE);
    }
    public boolean addCheddarCheese() {
        return addToppingToPizza(Topping.CHEDDAR_CHEESE);
    }
    public boolean removeCheddarCheese() {
        return removeToppingFromPizza(Topping.CHEDDAR_CHEESE);
    }
    public boolean addFetaCheese() {
        return addToppingToPizza(Topping.FETA_CHEESE);
    }
    public boolean removeFetaCheese() {
        return removeToppingFromPizza(Topping.FETA_CHEESE);
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
        return meatCount == pizzaType.maxMeatCount && veggieCount == pizzaType.maxVeggieCount &&
                cheeseCount == pizzaType.maxCheeseCount;
    }
    private static ArrayList<Topping> setPizza(PizzaType pizzaType) {
        switch (pizzaType) {
            case HOUSE_PIZZA:
                return new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                        Topping.GREEN_PEPPERS, Topping.MOZZARELLA_CHEESE));
            case MEAT_LOVER_PIZZA:
                return new ArrayList<>(Arrays.asList(Topping.BACON, Topping.PEPERONI, Topping.HAM,
                        Topping.SAUSAGES, Topping.CHEDDAR_CHEESE));
            case VEGGIE_PIZZA:
                return new ArrayList<>(Arrays.asList(Topping.BLACK_OLIVES, Topping.RED_ONIONS,
                        Topping.GREEN_PEPPERS));
            case FREE_SOUL_PIZZA:
                return new ArrayList<>();
            default:
                assert (false);
                return null;
        }
    }
}
