package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class Wraith extends AdjacentUnit {

    private boolean hasShieldUsedAll;
    private boolean hasAttacked;
    private final IntVector2D startPos;

    public Wraith(IntVector2D currPos) {
        super(currPos, UnitData.WRAITH.getHp(), UnitData.WRAITH.getUnitType(),
                UnitData.WRAITH.getSight(), UnitData.WRAITH.getAoe(), UnitData.WRAITH.getAp());
        startPos = new IntVector2D(currPos.getX(), currPos.getY());
    }

    public IntVector2D getStartPos() {
        return startPos;
    }
    public boolean getHasAttacked() {
        return hasAttacked;
    }
    public boolean getHasShieldUsedAll() {
        return hasShieldUsedAll;
    }

    @Override
    public void onAttacked(int damage) {
        hasAttacked = true;
        if (hasShieldUsedAll) {
            hp -= damage;
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
    public void getPriorityPos(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {

        priorities.clear();

        // 공중 유닛을 먼저 물색함. priorities에 들어감
        getAirEnemies(sourceUnits, priorities);

        if (priorities.size() == 1) {
            targetPos = new IntVector2D(priorities.get(0).getPosition());
            return;
        } else if (priorities.size() > 1) {
            sourceUnits.clear();
            sourceUnits.addAll(priorities);
            priorities.clear();
        }

        // AdjacentUnit에 있는 함수를 호출
        if (getEnemiesInAttackRange().isEmpty()) {
            targetPos = getPriorityPosInSight(sourceUnits, priorities);
        } else {
            targetPos = getPriorityPosInAttack(sourceUnits, priorities);
        }
    }

    @Override
    public void passThisTurn() {
        if (getPosition() != startPos) {
            moveToTarget(startPos);
        }
    }

    private void getAirEnemies(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {
        for (Unit u : sourceUnits) {
            if (u.getUnitType() == UnitType.AIR) {
                priorities.add(u);
            }
        }
    }
}
