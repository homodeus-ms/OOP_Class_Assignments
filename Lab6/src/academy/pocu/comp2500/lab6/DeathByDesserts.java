package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class DeathByDesserts extends Combo {

    public DeathByDesserts() {
        super(FoodType.DEATH_BY_DESSERTS);
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        super.desserts.clear();
        desserts.add(dessert1);
        desserts.add(dessert2);
        desserts.add(dessert3);
        desserts.add(dessert4);
        dessertCount = 4;
    }
}
