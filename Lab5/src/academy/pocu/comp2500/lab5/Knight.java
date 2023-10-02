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
        if (this.pet == null) {
            return;
        }
        // 혹시 모를 언더플로우를 대비해서..
        int damage;
        if (this.getAttack() + this.pet.getAttack() < other.getDefense() + 1) {
            damage = 1;
        } else {
            damage = (int)((this.getAttack() + this.pet.getAttack() - other.getDefense()) / 2.0);
        }

        calculateHp(other, damage);
    }
}
