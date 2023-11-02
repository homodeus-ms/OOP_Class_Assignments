package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {

    private static SimulationManager instance;
    private final ArrayList<Unit> units;

    private SimulationManager(ArrayList<Unit> units) {
        this.units = units;
    }

    public static SimulationManager getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new SimulationManager(new ArrayList<>());

        return instance;
    }

    public ArrayList<Unit> getUnits() {

        return units;
    }

    public void spawn(Unit unit) {
        unit.onSpawn();
        this.units.add(unit);
    }

    // 이걸 이렇게 해야 하는건가?


    public void registerThinkable(ThinkableUnit unit) {

    }

    public void registerMovable(IMovable unit) {

    }

    public void registerCollisionEventListener(Mine mine) {

    }

    public void update() {
        // spwaned Unit이 없는 경우 바로 리턴
        if (units.isEmpty()) {
            return;
        }

        for (Unit u : units) {
            u.setEnemiesInAttackRangeAndSightRange();

            if (u.getEnemiesInAttackRange().isEmpty() && u.getEnemiesInSight().isEmpty()) {
                continue;
            } else if (u.getEnemiesInAttackRange().isEmpty()) {
                u.getPriorityPosOrNull(u.getEnemiesInSight(), u.getEnemyPriorities());
            } else {
                u.getPriorityPosOrNull(u.getEnemiesInAttackRange(), u.getEnemyPriorities());
            }
        }

        for (Unit u : units) {
            if (u.getEnemiesInAttackRange().isEmpty() && u.getEnemiesInSight().isEmpty()) {
                u.passThisTurn();
                u.hasActed = true;
            } else if (u.getEnemiesInAttackRange().isEmpty()) {    // 공격할 적이 없음
                u.moveToTarget(u.getTargetPosOrNull());
                u.hasActed = true;
            }
        }

        // 충돌관련? 지뢰
        for (Unit u : units) {
            if (u.getUnitType() == UnitType.BURROWED) {
                ((Mine) u).checkTriggerAndExplodeOrNot(units, u.getEnemiesInAttackRange());
            }
        }

        // 공격할 적이 있는 unit들이 공격행위를 함
        for (Unit u : units) {

            if (u.getUnitType() == UnitType.BURROWED || u.hasActed()) {
                continue;
            } else if (u.getSymbol() == 'D') {
                u.attack();
                continue;
            }

            u.attack();
            u.hasActed = true;

        }

        // 모든 행위가 끝나고 죽은 유닛들을 제거함
        for (int i = 0; i < units.size(); ++i) {

            Unit unit = units.get(i);

            assert (unit.hasActed);

            unit.goNextTurn();

            if (unit.getHp() <= 0) {
                units.remove(unit);
                --i;

            } else if (unit.getUnitType() == UnitType.AIR && ((Wraith) unit).getHasAttacked()) {
                ((Wraith) unit).goNextTurn();
            }
        }
    }
}