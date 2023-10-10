package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(PizzaType.VEGGIE_PIZZA);
    }

    public boolean addMozzarellaCheese() {
        return addCheese(Topping.MOZZARELLA_CHEESE);
    }
    public boolean removeMozzarellaCheese() {
        return removeCheese(Topping.MOZZARELLA_CHEESE);
    }
    public boolean addCheddarCheese() {
        return addCheese(Topping.CHEDDAR_CHEESE);
    }
    public boolean removeCheddarCheese() {
        return removeCheese(Topping.CHEDDAR_CHEESE);
    }
    public boolean addFetaCheese() {
        return addCheese(Topping.FETA_CHEESE);
    }
    public boolean removeFetaCheese() {
        return removeCheese(Topping.FETA_CHEESE);
    }
}
