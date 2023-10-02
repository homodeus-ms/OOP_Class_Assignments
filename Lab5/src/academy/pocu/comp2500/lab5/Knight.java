package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public void setPet(Pet petOrNull) {
        this.pet = petOrNull;
    }
    public void attackTogether(Barbarian other) {
        if (this == other || !this.isAlive || !other.isAlive || this.pet == null) {
            return;
        }
        // 혹시 모를 언더플로우를 대비해서..
        int damage;
        if (this.attack + this.pet.getAttack() < other.defense + 1) {
            damage = 1;
        } else {
            damage = (int) ((this.attack + this.pet.getAttack() - other.defense) / 2.0);
        }

        if (damage >= other.hp) {
            other.hp = 0;
            other.isAlive = false;
        } else {
            other.hp -= damage;
        }
    }
}
