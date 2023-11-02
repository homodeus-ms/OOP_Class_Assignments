package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Wraith extends ThinkableUnit implements IMovable {

    private boolean hasShieldUsedAll;
    private boolean hasAttacked;
    private final IntVector2D startPos;

    public Wraith(IntVector2D currPos) {
        super(currPos, UnitData.WRAITH.getHp(), UnitData.WRAITH.getUnitType(),
                UnitData.WRAITH.getSight(), UnitData.WRAITH.getAoe(), UnitData.WRAITH.getAp());
        startPos = currPos;
    }

    public IntVector2D getStartPos() {
        return startPos;
    }
    public boolean getHasAttacked() {
        return hasAttacked;
    }

    // 1. Update() 함수 내부에서 attackIntent에 필요한 정보들이 들어가 있음
    // 2. 탱크는 공격전 모드 확인을 해야함
    // 3. target Position에 Ap 데미지가 들어가고, AOE계산을 해서
    //    해당 AOE가 적용되는 position들에 AOE Damage를 주어야 함

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
    public void onAttacked(int damage) {
        hasAttacked = true;
        if (hasShieldUsedAll) {
            hp -= damage;
            //hp = Math.max(0, hp);
        }
    }

    @Override
    public void goNextTurn() {
        if (hasAttacked) {
            hasShieldUsedAll = true;
        }

        hasActed = false;
    }

    @Override
    public char getSymbol() {
        return UnitData.WRAITH.getMark();
    }

    @Override
    public void getPriorityPosOrNull(ArrayList<Unit> sourceUnits,
                                     ArrayList<Unit> priorities) {

        if (sourceUnits.isEmpty()) {
            return;
        }

        priorities.clear();

        // 공중 유닛을 우선 후보로 선정
        getAirEnemies(sourceUnits, priorities);

        if (priorities.size() == 1) {
            targetPosOrNull.makeDeepCopy(priorities.get(0).getPosition());
            return;
        } else if (priorities.size() > 1) {
            sourceUnits.clear();
            sourceUnits.addAll(priorities);
            priorities.clear();
        }

        // 만약 공격사항이 아니라면 가까이 있는 것이 priority, 공격상황이라면 minHp가 priority
        // getEnemiesInAttackRange가 비어있다는 것은 공격상황이 아니라는 것
        if (getEnemiesInAttackRange().isEmpty()) {
            getClosestTarget(sourceUnits, priorities);

            if (priorities.size() == 1) {
                targetPosOrNull.makeDeepCopy(priorities.get(0).getPosition());
                return;

                // 가까운 거리의 적들을 추렸는데도 여러개가 있을 경우
            } else if (priorities.size() > 1) {

                sourceUnits.clear();

                sourceUnits.addAll(priorities);

                getEnemyPriorities().clear();

                getMinHpTarget(sourceUnits, priorities);
            }
            // 공격 상황인 경우, 바로 minHp enemy를 찾으러감
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


    @Override
    public void moveToTarget(IntVector2D targetPos) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        int targetX = targetPos.getX();
        int targetY = targetPos.getY();

        if (y == targetY) {
            if (x < targetX) {
                getPosition().setX(x + 1);
            } else {
                getPosition().setX(x - 1);
            }
        } else if (y < targetY) {
            getPosition().setY(y + 1);
        } else {
            getPosition().setY(y - 1);
        }
    }

    @Override
    public void passThisTurn() {
        moveToTarget(startPos);
    }

    private void getAirEnemies(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {
        for (Unit u : sourceUnits) {
            if (u.getUnitType() == UnitType.AIR) {
                priorities.add(u);
            }
        }
    }

}
