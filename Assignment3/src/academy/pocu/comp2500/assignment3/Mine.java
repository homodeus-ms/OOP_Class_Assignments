package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Mine extends Unit implements ICollisionEventListener {

    protected int triggerCountDown;

    public Mine(IntVector2D currPos, int maxTriggerCount) {
        this(currPos, UnitData.MINE.getHp(), UnitData.MINE.getUnitType(),
                UnitData.MINE.getSight(), UnitData.MINE.getAoe(), UnitData.MINE.getAp(),
                maxTriggerCount);
    }
    protected Mine(IntVector2D currPos, int hp, UnitType type, int sight,
                   int aoe, int ap, int maxTriggerCount) {
        super(currPos, hp, type, sight, aoe, ap);

        this.triggerCountDown = maxTriggerCount;
    }

    public int getTriggerCountDown() {
        return triggerCountDown;
    }

    @Override
    public char getSymbol() {
        return UnitData.MINE.getMark();
    }

    @Override

    public AttackIntent attack() {
        return null;
    }

    public void explode(ArrayList<Unit> targets) {
        for (Unit u : targets) {
            u.onAttacked(getAp());
        }
        this.hp = 0;
    }

    @Override
    public void checkTriggerAndExplodeOrNot(ArrayList<Unit> sourceUnits, ArrayList<Unit> targets) {
        targets.clear();

        for (Unit u : sourceUnits) {
            if (this != u && u.getPosition().equals(this.getPosition()) &&
                    u.getUnitType() != UnitType.AIR) {
                --triggerCountDown;

                targets.add(u);
            }
        }
        if (triggerCountDown <= 0) {
            explode(targets);
        }
    }

    @Override
    public void setEnemiesInAttackRangeAndSightRange() {
        getEnemiesInAttackRange().clear();
        getEnemiesInSight().clear();
        return;
    }

    @Override
    public boolean isVisible(Unit other) {
        return other.getUnitType() == UnitType.GROUND;
    }

    @Override
    protected boolean isEnemyInSight(Unit enemy) {
        return false;
    }

    @Override
    protected boolean isAttackable(Unit target) {
        return this.getPosition() == target.getPosition();
    }
}
