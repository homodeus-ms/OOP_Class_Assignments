package academy.pocu.comp2500.lab6;

public class MeatLoverPizza extends Pizza {

    public MeatLoverPizza() {
        super(PizzaType.MEAT_LOVER_PIZZA);
    }


    public boolean addBlackOlives() {
        return addVeggie(Topping.BLACK_OLIVES);
    }
    public boolean removeBlackOlives() {
        return removeVeggie(Topping.BLACK_OLIVES);
    }
    public boolean addRedOnions() {
        return addVeggie(Topping.RED_ONIONS);
    }
    public boolean removeRedOnions() {
        return removeVeggie(Topping.RED_ONIONS);
    }
    public boolean addGreenPeppers() {
        return addVeggie(Topping.GREEN_PEPPERS);
    }
    public boolean removeGreenPeppers() {
        return removeVeggie(Topping.GREEN_PEPPERS);
    }
}
