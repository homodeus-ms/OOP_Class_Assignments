package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class ThinkableUnit extends Unit {

    protected ThinkableUnit(IntVector2D currPos, int hp, final UnitType unitType,
                            final int sightRange, final int aoe, final int ap) {
        super(currPos, hp, unitType, sightRange, aoe, ap);
    }

    // 밑의 함수들은 ThinkableUnit을 상속받는 머린, 탱크, 레이스, 터렛이 오버라이드할 것임
    // 여기에 구현되어 있는 디폴트는 머린

    public void getPriorityPosOrNull(ArrayList<Unit> sourceUnits,
                                            ArrayList<Unit> priorities) {

        if (sourceUnits.isEmpty()) {
            return;
        }

        priorities.clear();

        if (getEnemiesInAttackRange().isEmpty()) {
            getClosestTarget(getEnemiesInSight(), getEnemyPriorities());

            if (priorities.size() != 1) {
                getEnemiesInSight().clear();

                for (Unit u : priorities) {
                    getEnemiesInSight().add(u);
                }

                getEnemyPriorities().clear();

                getMinHpTarget(getEnemiesInSight(), getEnemyPriorities());
            }
        } else {
            getMinHpTarget(sourceUnits, priorities);
        }

        if (priorities.size() == 1) {
            targetPosOrNull.makeDeepCopy(priorities.get(0).getPosition());
            return;
        } else {
            targetPosOrNull.makeDeepCopy(findPriorityPosByDirection(priorities));
            return;
        }
    }

    public void getClosestTarget(ArrayList<Unit> sourceUnit, ArrayList<Unit> priorities) {
        int minDist = Integer.MAX_VALUE;
        for (Unit u : sourceUnit) {
            int distance = getPosition().getManhattanDistance(u.getPosition());
            if (priorities.isEmpty() || distance < minDist) {
                minDist = distance;
                priorities.clear();
                priorities.add(u);
            } else if (distance == minDist) {
                priorities.add(u);
            }
        }
    }
    public void getMinHpTarget(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {
        int minHp = 0;

        for (Unit u : sourceUnits) {
            if (priorities.isEmpty() || u.getHp() < minHp) {
                minHp = u.getHp();
                priorities.clear();
                priorities.add(u);
            } else if (u.getHp() == minHp) {
                priorities.add(u);
            }
        }
    }


    protected IntVector2D findPriorityPosByDirection(ArrayList<Unit> priorities) {
        IntVector2D pos = new IntVector2D(getPosition().getX(), getPosition().getY());

        int searchCount = 0;    // 0:samePos, 1:north... 4:west, 4 is Max in case of Marine

        assert (!priorities.isEmpty());

        do {
            for (Unit target : priorities) {
                if (target.getPosition().equals(pos)) {
                    return pos;
                }
            }

            getNextPos(searchCount++, pos);
        } while (!pos.equals(this.getPosition()));

        assert (false) : "It should be returned in previous loop";
        return null;
    }

    // 처음 북쪽, 이후 시계방향으로 훑는 것, default는 마린과 레이스
    protected void getNextPos(int searchCount, IntVector2D pos) {
        switch (searchCount) {
            case 0:    // north (0, -1)
                pos.setY(pos.getY() - 1);
                break;
            case 1:    // east (1, 0)
                pos.setX(pos.getX() + 1);
                pos.setY(pos.getY() + 1);
                break;
            case 2:    // south (0, 1)
                pos.setX(pos.getX() - 1);
                pos.setY(pos.getY() + 1);
                break;
            case 3:    // west (-1, 0)
                pos.setX(pos.getX() - 1);
                pos.setY(pos.getY() - 1);
                break;
            case 4:    // back to original Pos (0, 0)
                pos.setX(pos.getX() + 1);
                break;
            default:
                assert (false);
                break;
        }
    }
}
