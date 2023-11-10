package academy.pocu.comp2500.assignment3;

public final class AttackIntent {
    private IntVector2D targetPos;
    private int damage;
    private Unit attacker;

    public AttackIntent(IntVector2D attackPos, int damage, Unit attacker) {
        this.targetPos = attackPos;
        this.damage = damage;
        this.attacker = attacker;
    }

    public IntVector2D getAttackPos() {
        return targetPos;
    }

    public int getDamage() {
        return damage;
    }

    public Unit getTarget() {
        return attacker;
    }

    void setAttackIntent(IntVector2D targetPos, int damage, Unit attacker) {
        this.targetPos = targetPos;
        this.damage = damage;
        this.attacker = attacker;
    }
}
