package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Turret extends SelectiveAttackUnit {

    public Turret(IntVector2D currPos) {
        super(currPos, UnitData.TURRET.getHp(), UnitData.TURRET.getUnitType(),
                UnitData.TURRET.getSight(), UnitData.TURRET.getAoe(), UnitData.TURRET.getAp());

    }

    @Override
    public AttackIntent attack() {

        makeAttackIntent();

        IntVector2D targetPos = getAttackIntent().getAttackPos();
        ArrayList<Unit> spawnedUnit = SimulationManager.getInstance().getUnits();

        for (Unit enemy : spawnedUnit) {
            if (this != enemy && this.isVisible(enemy)) {
                IntVector2D enemyPos = enemy.getPosition();

                if (targetPos.equals(enemyPos)) {
                    enemy.onAttacked(getAp());
                }
            }
        }

        return getAttackIntent();
    }

    @Override
    public char getSymbol() {
        return UnitData.TURRET.getMark();
    }

    @Override
    public void getPriorityPos(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {

        if (enemiesInAttackRange.isEmpty()) {
            hasActed = true;
            return;
        }

        priorities.clear();

        targetPosOrNull = getPriorityPosInAttack(sourceUnits, priorities);
    }

    @Override
    public boolean isVisible(Unit other) {
        return other.getUnitType() == UnitType.AIR;
    }
    @Override
    public boolean isAttackable(Unit target) {
        return this.getPosition().getDistance(target.getPosition()) < 1.415 + EPSILON;
    }
}
