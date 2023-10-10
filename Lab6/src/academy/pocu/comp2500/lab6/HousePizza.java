package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(PizzaType.HOUSE_PIZZA);
    }

    public boolean addBacon() {
        return addTopping(Topping.BACON);
    }
    public boolean removeBacon() {
        return removeTopping(Topping.BACON);
    }
    public boolean addPeperoni() {
        return addTopping(Topping.PEPERONI);
    }
    public boolean removePeperoni() {
        return removeTopping(Topping.PEPERONI);
    }
    public boolean addSausages() {
        return addTopping(Topping.SAUSAGES);
    }
    public boolean removeSausages() {
        return removeTopping(Topping.SAUSAGES);
    }
}
