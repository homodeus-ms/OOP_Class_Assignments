package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class SmartMine extends Mine implements IAoeAttackable {

    private final int maxEnemies;

    public SmartMine(IntVector2D currPos, int maxTriggerCount, int maxEnemies) {
        super(currPos, UnitData.SMART_MINE.getHp(), UnitData.SMART_MINE.getUnitType(),
                UnitData.SMART_MINE.getSight(), UnitData.SMART_MINE.getAoe(),
                UnitData.SMART_MINE.getAp(), maxTriggerCount);
        this.maxEnemies = maxEnemies;
    }

    public int getMaxEnemies() {
        return maxEnemies;
    }

    @Override
    public void explode(ArrayList<Unit> targets) {
        for (Unit u : targets) {

            IntVector2D myPos = getPosition();
            IntVector2D enemyPos = u.getPosition();

            if (u.getUnitType() == UnitType.GROUND) {
                if (myPos.equals(u.getPosition())) {
                    u.onAttacked(getAp());
                } else if (myPos.getDistance(enemyPos) < 2.0 - EPSILON) {
                    u.onAttacked(calculateAoeDamage(enemyPos));
                }
            }
        }

        this.hp = 0;
    }

    // 터지는 조건인지 검사후 조건이 되면 함수내부에서 터짐
    @Override
    public void checkTriggerAndExplodeOrNot(ArrayList<Unit> sourceUnits, ArrayList<Unit> targets) {
        for (Unit u : sourceUnits) {
            if (u.getPosition().equals(this.getPosition()) &&
                    u.getUnitType() == UnitType.GROUND) {
                --triggerCountDown;

                targets.add(u);
            }
        }
        if (triggerCountDown <= 0) {
            // Aoe도 계산을 해야하니까 그냥 전체 유닛목록을 보냄
            explode(SimulationManager.getInstance().getUnits());
        }

        targets.clear();

        for (Unit u : sourceUnits) {
            if (u.getUnitType() == UnitType.GROUND && isEnemyInSight(u)) {
                targets.add(u);
            }
        }

        if (targets.size() >= maxEnemies) {
            explode(SimulationManager.getInstance().getUnits());
        }
    }

    @Override
    public char getSymbol() {
        return UnitData.SMART_MINE.getMark();
    }

    @Override
    public boolean isEnemyInSight(Unit enemy) {
        return getPosition().getDistance(enemy.getPosition()) < 2.0 - EPSILON;
    }

    @Override
    public int calculateAoeDamage(IntVector2D targetPos) {
        assert (this.getPosition().getManhattanDistance(targetPos) >= 1 &&
                this.getPosition().getDistance(targetPos) < 2.0 - EPSILON);

        int damage;
        final int DISTANCE = 1;

        damage = (int) (getAp() * (1 - DISTANCE / (getAoe() + 1.0)));

        return damage;
    }
}
