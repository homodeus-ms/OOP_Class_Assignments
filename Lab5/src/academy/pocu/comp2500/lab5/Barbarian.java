package academy.pocu.comp2500.lab5;
public class Barbarian {
    protected final String name;
    protected final int attack;
    protected final int defense;
    protected final int maxHp;
    protected int hp;
    protected boolean isAlive;

    public Barbarian(String name, int hp, int attack, int defense) {
        assert (hp > 0 && attack >= 0 && defense >= 0) : "stat should > 0";
        assert (name != null) : "name is null";

        this.name = name;
        this.attack = attack;
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        isAlive = true;
    }

    public int getHp() {
        return this.hp;
    }

    public void attack(Barbarian other) {

        if (this == other || !this.isAlive || !other.isAlive) {
            return;
        }

        // 혹시 모를 언더플로우를 대비해서..
        int damage;
        if (this.attack < other.defense + 1) {
            damage = 1;
        } else {
            damage = (int) ((this.attack - other.defense) / 2.0);
        }

        if (damage >= other.hp) {
            other.hp = 0;
            other.isAlive = false;
        } else {
            other.hp -= damage;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }
}
