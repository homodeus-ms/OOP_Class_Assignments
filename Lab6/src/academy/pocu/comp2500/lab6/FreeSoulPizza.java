package academy.pocu.comp2500.lab6;

public class FreeSoulPizza extends Pizza {

    public FreeSoulPizza() {
        super(PizzaType.FREE_SOUL_PIZZA);
    }

    /*public boolean addTopping(Topping topping) {
        super.addTopping(topping)
        ToppingType toppingType = topping.getToppingType();

        if (toppingType == ToppingType.MEAT && this.meatCount >= FREE_SOUL_PIZZA_MAX_MEAT_COUNT
                || toppingType == ToppingType.VEGGIE && veggieCount >= FREE_SOUL_PIZZA_MAX_VEGGIE_COUNT
                || toppingType == ToppingType.CHEESE && cheeseCount >= FREE_SOUL_PIZZA_MAX_CHEESE_COUNT) {
            return false;
        }

        switch (toppingType) {
            case MEAT:
                return addMeat(topping);
            case VEGGIE:
                return addVeggie(topping);
            case CHEESE:
                return addCheese(topping);
            default:
                assert (false);
                return false;
        }
    }*/
    /*public boolean removeTopping(Topping topping) {
        switch (topping.getToppingType()) {
            case MEAT:
                return removeMeat(topping);
            case VEGGIE:
                return removeVeggie(topping);
            case CHEESE:
                return removeCheese(topping);
            default:
                assert (false);
                return false;
        }
    }*/
}
