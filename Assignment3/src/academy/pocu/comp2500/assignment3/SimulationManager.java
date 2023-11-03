package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {

    private static SimulationManager instance;
    private final ArrayList<Unit> units;
    public final ArrayList<Unit> thinkableUnits;
    public final ArrayList<Unit> movableUnits;
    public final ArrayList<Unit> collisionEventListeners;

    private SimulationManager() {
        units = new ArrayList<>();
        thinkableUnits = new ArrayList<>();
        movableUnits = new ArrayList<>();
        collisionEventListeners = new ArrayList<>();
    }

    public static SimulationManager getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new SimulationManager();

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

    public void registerThinkable(Unit thinkableUnit) {
        thinkableUnits.add(thinkableUnit);
    }

    public void registerMovable(Unit movableUnit) {
        movableUnits.add(movableUnit);
    }

    public void registerCollisionEventListener(Unit unit) {
        collisionEventListeners.add(unit);
    }

    public void update() {
        // spwaned Unit이 없는 경우 바로 리턴
        if (units.isEmpty()) {
            return;
        }

        // 이 for문에서 각 유닛들은 공격할 수 있는 적들과, 시야에 있는 적들을 파악
        // 최우선으로 행동할 vector2D를 찾음
        for (Unit u : thinkableUnits) {

            u.setEnemiesInAttackRangeAndSightRange();

            if (u.getEnemiesInAttackRange().isEmpty() && u.getEnemiesInSight().isEmpty()) {
                continue;
            } else if (u.getEnemiesInAttackRange().isEmpty()) {
                ((ThinkableUnit) u).getPriorityPosOrNull(u.getEnemiesInSight(), u.getEnemyPriorities());
            } else {
                ((ThinkableUnit) u).getPriorityPosOrNull(u.getEnemiesInAttackRange(), u.getEnemyPriorities());
            }
        }

        // 1. 공격할 적이나 시야에 적이 없는 유닛들이 자신의 행동을 함
        // 2. 공격할 적이 없고 시야에 적이 있는 유닛들이 이동을 함
        for (Unit u : movableUnits) {
            //Unit u = (Unit) movableUnit;
            IMovable movableUnit = (IMovable) u;

            if (u.getEnemiesInAttackRange().isEmpty() && u.getEnemiesInSight().isEmpty()) {
                movableUnit.passThisTurn();
                u.hasActed = true;
            } else if (u.getEnemiesInAttackRange().isEmpty()) {    // 공격할 적이 없음
                movableUnit.moveToTarget(u.getTargetPosOrNull());
                u.hasActed = true;
            }
        }

        // 충돌관련? 지뢰
        for (Unit u : collisionEventListeners) {

            ((Mine) u).checkTriggerAndExplodeOrNot(units, u.getEnemiesInAttackRange());

        }

        // 공격할 적이 있는 unit들이 공격행위를 함
        for (Unit u : thinkableUnits) {

            if (!u.hasActed) {
                u.attack();
                u.hasActed = true;
            }
        }

        // 모든 행위가 끝나고 죽은 유닛들을 제거함
        // goNextTurn() : 위에서 turn을 넘기는 행동이나 이동을 했던 유닛들의 불리언 변수가 true로
        // 체크 되는데 그것들을 다음 턴을 위해 다시 false로 바꿔줌
        for (int i = 0; i < units.size(); ++i) {

            Unit unit = units.get(i);

            if (unit.getHp() <= 0) {

                units.remove(unit);
                thinkableUnits.remove(unit);
                movableUnits.remove(unit);
                collisionEventListeners.remove(unit);

                --i;

            } else {
                unit.goNextTurn();
            }
        }
    }
}