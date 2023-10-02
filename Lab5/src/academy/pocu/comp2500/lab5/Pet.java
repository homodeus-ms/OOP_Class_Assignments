package academy.pocu.comp2500.lab5;

public class Pet {
    private String Name;
    private int attack;

    public Pet(String name, int attack) {
        this.Name = name;
        this.attack = attack;
    }

    public String getName() {
        return Name;
    }

    public int getAttack() {
        return attack;
    }
}
