package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {

    public MeatLoverPizza() {
        super(PizzaType.MEAT_LOVER_PIZZA);
    }


    public boolean addBlackOlives() {
        return addTopping(Topping.BLACK_OLIVES);
    }
    public boolean removeBlackOlives() {
        return removeTopping(Topping.BLACK_OLIVES);
    }
    public boolean addRedOnions() {
        return addTopping(Topping.RED_ONIONS);
    }
    public boolean removeRedOnions() {
        return removeTopping(Topping.RED_ONIONS);
    }
    public boolean addGreenPeppers() {
        return addTopping(Topping.GREEN_PEPPERS);
    }
    public boolean removeGreenPeppers() {
        return removeTopping(Topping.GREEN_PEPPERS);
    }
}
