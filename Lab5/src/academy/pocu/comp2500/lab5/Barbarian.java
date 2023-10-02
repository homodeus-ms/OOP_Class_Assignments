package academy.pocu.comp2500.lab5;

public class Barbarian {
    private final String name;
    private final int attack;
    private final int defense;
    protected int hp;

    public Barbarian(String name, int hp, int attack, int defense) {
        assert (hp > 0 && attack >= 0 && defense >= 0) : "stat should > 0";
        assert (name != null) : "name is null";

        this.name = name;
        this.attack = attack;
        this.hp = hp;
        this.defense = defense;
    }
    public int getHp() {
        return this.hp;
    }
    public String getName() {
        return this.name;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getDefense() {
        return this.defense;
    }

    public void attack(Barbarian other) {
        // 혹시 모를 언더플로우를 대비해서..
        int damage;
        if (this.attack < other.defense + 1) {
            damage = 1;
        } else {
            damage = (int)((this.attack - other.defense) / 2.0);
        }

        calculateHp(other, damage);
    }

    protected void calculateHp(Barbarian other, int damage) {
        // 혹시 모를 언더플로우를 위해
        if (damage > other.hp) {
            other.hp = 0;
        } else {
            other.hp -= damage;
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
}
