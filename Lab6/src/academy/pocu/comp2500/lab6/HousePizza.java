package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(PizzaType.HOUSE_PIZZA);
    }

    public boolean addBacon() {
        return addMeat(Topping.BACON);
    }
    public boolean removeBacon() {
        return removeMeat(Topping.BACON);
    }
    public boolean addPeperoni() {
        return addMeat(Topping.PEPERONI);
    }
    public boolean removePeperoni() {
        return removeMeat(Topping.PEPERONI);
    }
    public boolean addSausages() {
        return addMeat(Topping.SAUSAGES);
    }
    public boolean removeSausages() {
        return removeMeat(Topping.SAUSAGES);
    }
}
