package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Menu {
    /*protected static final int HOUSE_PIZZA_PRICE = 20;
    protected static final int MEAT_LOVER_PIZZA_PRICE = 21;
    protected static final int VEGGIE_PIZZA_PRICE = 17;
    protected static final int FREE_SOUL_PIZZA_PRICE = 25;
    protected static final int NO_HEAVY_MEAL_PRICE = 15;
    protected static final int THREE_COURSE_MEAL_PRICE = 25;
    protected static final int DEATH_BY_DESSERTS_PRICE = 20;*/

    public enum FoodType {
        HOUSE_PIZZA(20),
        MEAT_LOVER_PIZZA(21),
        VEGGIE_PIZZA(17),
        FREE_SOUL_PIZZA(25),
        NO_HEAVY_MEAL(15),
        THREE_COURSE_MEAL(25),
        DEATH_BY_DESSERTS(20);

        private final int price;

        FoodType(int price) {
            this.price = price;
        }
        /*public int getPrice() {
            return this.price;
        }*/
    }

    protected final FoodType foodType;

    protected Menu(FoodType foodType) {
        this.foodType = foodType;
    }

    /*protected FoodType getFoodType() {
        return this.foodType;
    }*/

    public int getPrice() {
        return foodType.price;
    }
}
