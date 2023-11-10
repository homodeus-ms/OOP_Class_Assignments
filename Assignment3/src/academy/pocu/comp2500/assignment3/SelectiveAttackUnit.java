package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class SelectiveAttackUnit extends Unit implements IThinkable {

    protected SelectiveAttackUnit(IntVector2D currPos, int hp, final UnitType unitType,
                                  final int sightRange, final int aoe, final int ap) {
        super(currPos, hp, unitType, sightRange, aoe, ap);
    }

    @Override
    public void findEnemiesInAttackRangeAndSightRange() {
        enemiesInSight.clear();
        enemiesInAttackRange.clear();

        ArrayList<Unit> spawnedUnit = SimulationManager.getInstance().getUnits();

        for (Unit u : spawnedUnit) {
            if (this != u && isVisible(u)) {
                if (isAttackable(u)) {
                    enemiesInAttackRange.add(u);
                } else if (isEnemyInSight(u)) {
                    enemiesInSight.add(u);
                }
            }
        }
    }

    // 머린과 레이스가 공통으로 쓸 수 있는 함수들이 좀 있기 때문에
    // 추상메서드로 만들지 않고 구현까지 함. 필요하면 밑의 클래스에서 오버라이드로
    public void getPriorityPos(ArrayList<Unit> sourceUnits,
                                     ArrayList<Unit> priorities) {

        priorities.clear();

        if (getEnemiesInAttackRange().isEmpty()) {
            targetPosOrNull = getPriorityPosInAttack(sourceUnits, priorities);
        } else {
            targetPosOrNull = getPriorityPosInSight(sourceUnits, priorities);
        }
    }

    public IntVector2D getPriorityPosInAttack(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {
        getMinHpTarget(sourceUnits, priorities);
        return new IntVector2D(findPriorityPosByDirection(priorities));
    }
    public IntVector2D getPriorityPosInSight(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {

        getClosestTarget(sourceUnits, priorities);

        if (priorities.size() != 1) {
            sourceUnits.clear();
            sourceUnits.addAll(priorities);
            priorities.clear();

            getMinHpTarget(sourceUnits, priorities);
        }

        return new IntVector2D(findPriorityPosByDirection(priorities));
    }

    public void getClosestTarget(ArrayList<Unit> sourceUnit, ArrayList<Unit> priorities) {
        int minDist = Integer.MAX_VALUE;
        for (Unit u : sourceUnit) {
            int distance = getPosition().getManhattanDistance(u.getPosition());
            if (distance < minDist) {
                minDist = distance;
                priorities.clear();
                priorities.add(u);
            } else if (distance == minDist) {
                priorities.add(u);
            }
        }
    }
    public void getMinHpTarget(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {
        int minHp = Integer.MAX_VALUE;

        for (Unit u : sourceUnits) {
            if (u.getHp() < minHp) {
                minHp = u.getHp();
                priorities.clear();
                priorities.add(u);
            } else if (u.getHp() == minHp) {
                priorities.add(u);
            }
        }
    }

    protected IntVector2D findPriorityPosByDirection(ArrayList<Unit> priorities) {

        assert (!priorities.isEmpty()) : "List should not empty";

        Unit priority = null;
        double minDegree = 360;
        double currDegree;
        IntVector2D currPos = this.getPosition();

        for (Unit u : priorities) {
            IntVector2D pos = u.getPosition();
            if (currPos.equals(pos)) {
                return new IntVector2D(pos);
            }
            // y축(+ 방향)을 0도 기준을 잡고 x축 +방향이 90도, 시계 방향으로 증가함, 최소값일수록 우선순위임
            currDegree = (Math.toDegrees(Math.atan2(pos.getY() - currPos.getY(), pos.getX() - currPos.getX())) + 450) % 360;
            if (minDegree > currDegree) {
                minDegree = currDegree;
                priority = u;
            }
        }

        assert (priority != null);
        return new IntVector2D(priority.getPosition());
    }
}
