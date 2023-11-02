package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Turret extends ThinkableUnit {

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
    public void setEnemiesInAttackRangeAndSightRange() {

        enemiesInSight.clear();
        enemiesInAttackRange.clear();

        ArrayList<Unit> spawnedUnit = SimulationManager.getInstance().getUnits();

        for (Unit u : spawnedUnit) {
            if (this != u && isVisible(u)) {
                if (isAttackable(u)) {
                    enemiesInAttackRange.add(u);
                }
            }
        }
    }

    @Override
    public void getPriorityPosOrNull(ArrayList<Unit> sourceUnits,
                                     ArrayList<Unit> priorities) {

        if (sourceUnits.isEmpty()) {
            return;
        }

        // sourceUnit은 enemiesInAttackRange임.
        // 터렛이 공격할 수 있는 공중 유닛만 들어있음

        priorities.clear();

        getMinHpTarget(sourceUnits, priorities);

        if (priorities.size() == 1) {
            targetPosOrNull.makeDeepCopy(priorities.get(0).getPosition());
            return;
        } else {
            targetPosOrNull.makeDeepCopy(findPriorityPosByDirection(priorities));
            return;
        }
    }

    protected void getNextPos(int searchCount, IntVector2D pos) {
        switch (searchCount) {
            case 0:    // north (0, -1)
                pos.setY(pos.getY() - 1);
                break;
            case 1:    // (1, -1)
                pos.setX(pos.getX() + 1);
                break;
            case 2:    // east (1, 0)
                pos.setY(pos.getY() + 1);
                break;
            case 3:    // (1, 1)
                pos.setY(pos.getY() + 1);
                break;
            case 4:    // south (0, 1)
                pos.setX(pos.getX() - 1);
                break;
            case 5:    // (-1, 1)
                pos.setX(pos.getX() - 1);
                break;
            case 6:    // west (-1, 0)
                pos.setY(pos.getY() - 1);
                break;
            case 7:    // (-1, -1)
                pos.setY(pos.getY() - 1);
                break;
            case 8:    // back to original pos (0, 0)
                pos.setX(pos.getX() + 1);
                pos.setY(pos.getY() + 1);
                break;
            default:
                assert (false);
                break;
        }
    }
    @Override
    public boolean isVisible(Unit other) {
        return other.getUnitType() == UnitType.AIR;
    }
    @Override
    public boolean isAttackable(Unit target) {
        return this.getPosition().getDistance(target.getPosition()) < 2.0 - EPSILON;
    }
}
