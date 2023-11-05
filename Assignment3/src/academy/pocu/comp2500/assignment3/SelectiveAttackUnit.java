package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class SelectiveAttackUnit extends Unit implements IThinkable {

    protected SelectiveAttackUnit(IntVector2D currPos, int hp, final UnitType unitType,
                                  final int sightRange, final int aoe, final int ap) {
        super(currPos, hp, unitType, sightRange, aoe, ap);
    }

    // 밑의 함수들은 ThinkableUnit을 상속받는 머린, 탱크, 레이스, 터렛이 오버라이드할 것임
    // 여기에 구현되어 있는 디폴트는 머린

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

    public void getPriorityPosOrNull(ArrayList<Unit> sourceUnits,
                                     ArrayList<Unit> priorities) {

        priorities.clear();

        if (getEnemiesInAttackRange().isEmpty()) {
            getClosestTarget(sourceUnits, priorities);

            if (priorities.size() != 1) {
                sourceUnits.clear();

                sourceUnits.addAll(priorities);

                priorities.clear();

                getMinHpTarget(sourceUnits, priorities);
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

        boolean isSearchingAttackPos = this.isAttackable(priorities.get(0));

        IntVector2D pos = new IntVector2D(getPosition().getX(), getPosition().getY());

        // 지금 찾고 있는 것이 attack target인 경우
        if (isSearchingAttackPos) {
            int searchCount = 0;    // 0:samePos, 1:north... 4:west, 4 is Max in case of Marine

            do {
                for (Unit target : priorities) {
                    if (target.getPosition().equals(pos)) {
                        return pos;
                    }
                }

                getNextAttackPos(searchCount++, pos);
            } while (!pos.equals(this.getPosition()));
        } else {    // 공격할 적이 없어서 시야에 있는 따라갈 적을 찾는 경우
            return getMovePos(pos, priorities);
        }


        assert (false) : "It should be returned in previous loop";
        return null;
    }
    protected IntVector2D getMovePos(IntVector2D pos, ArrayList<Unit> priorities) {

        for (Unit target : priorities) {
            if (this.targetPosOrNull.equals(target.getPosition())) {
                return this.targetPosOrNull;
            }
        }

        int thisX = pos.getX();
        int thisY = pos.getY();

        IntVector2D res = null;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        // 만약 타겟의 x값이 0이상이면 y값이 가장 작은 게 타겟임
        for (Unit target : priorities) {
            int targetXDiff = target.getPosition().getX() - thisX;
            int targetYDiff = target.getPosition().getY() - thisY;
            if (targetXDiff >= 0) {
                if (targetYDiff < minY) {
                    minY = targetYDiff;
                    res = target.getPosition();
                }
            }
        }

        if (res != null) {
            return res;
        }

        // 위에서 만약 x값이 0 이상인게 없어서 여기까지 왔으면 y값이 가장 큰게 타겟임
        for (Unit target : priorities) {
            int targetXDiff = target.getPosition().getX() - thisX;
            int targetYDiff = target.getPosition().getY() - thisY;
            if (targetXDiff < 0) {
                if (targetYDiff > maxY) {
                    maxY = targetYDiff;
                    res = target.getPosition();
                }
            }
        }

        // 여기까지 왔는데 null인 경우는 없다
        assert (res != null);

        return res;

    }

    // 처음 북쪽, 이후 시계방향으로 훑는 것, default는 마린과 레이스
    protected void getNextAttackPos(int searchCount, IntVector2D pos) {
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
                pos.setX(this.getPosition().getX());
                pos.setY(this.getPosition().getY());
                break;
            default:
                assert (false);
                break;
        }
    }
}
