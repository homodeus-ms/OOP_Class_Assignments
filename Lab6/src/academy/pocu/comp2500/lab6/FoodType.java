package academy.pocu.comp2500.lab6;

public enum FoodType {
    HOUSE_PIZZA(20),
    MEAT_LOVER_PIZZA(21),
    VEGGIE_PIZZA(17),
    FREE_SOUL_PIZZA(25),
    NO_HEAVY_MEAL(15),
    THREE_COURSE_MEAL(25),
    DEATH_BY_DESSERTS(20);

    private final int price;

    FoodType(int price){
        this.price = price;
    }
    public int getPrice() {
        return this.price;
    }
}
