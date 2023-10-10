package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(PizzaType.VEGGIE_PIZZA);
    }

    public boolean addMozzarellaCheese() {
        return addTopping(Topping.MOZZARELLA_CHEESE);
    }
    public boolean removeMozzarellaCheese() {
        return removeTopping(Topping.MOZZARELLA_CHEESE);
    }
    public boolean addCheddarCheese() {
        return addTopping(Topping.CHEDDAR_CHEESE);
    }
    public boolean removeCheddarCheese() {
        return removeTopping(Topping.CHEDDAR_CHEESE);
    }
    public boolean addFetaCheese() {
        return addTopping(Topping.FETA_CHEESE);
    }
    public boolean removeFetaCheese() {
        return removeTopping(Topping.FETA_CHEESE);
    }
}
