package academy.pocu.comp2500.lab5;

public class Pet {
    private final String Name;
    private final int attack;

    public Pet(String name, int attack) {
        this.Name = name;
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }
}
