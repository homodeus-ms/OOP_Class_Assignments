package academy.pocu.comp2500.lab6;

public class DeathByDesserts extends Combo {

    public DeathByDesserts() {
        super(DEATH_BY_DESSERTS_PRICE);
    }
    public boolean isValid() {
        return appetizers.isEmpty() && mainCourse == null && desserts.size() == MAX_DESSERT_COUNT;
    }
    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        super.desserts.clear();
        desserts.add(dessert1);
        desserts.add(dessert2);
        desserts.add(dessert3);
        desserts.add(dessert4);
    }
}
