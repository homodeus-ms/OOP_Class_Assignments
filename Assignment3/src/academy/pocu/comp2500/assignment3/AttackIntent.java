package academy.pocu.comp2500.assignment3;

public final class AttackIntent {
    private final IntVector2D targetPos;
    private final int damage;
    private final Unit attacker;

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
}
