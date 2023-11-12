package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Tank extends SelectiveAttackUnit implements IMovable, IAoeAttackable {

    private boolean isSeigeMode;
    private boolean wasMovingToLeft;

    public Tank(IntVector2D currPos) {
        super(currPos, UnitData.TANK.getHp(), UnitData.TANK.getUnitType(),
                UnitData.TANK.getSight(), UnitData.TANK.getAoe(), UnitData.TANK.getAp());
    }

    public boolean getTankMode() {
        return this.isSeigeMode;
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

            IntVector2D enemyPos = enemy.getPosition();

            if (this != enemy && enemy.getUnitType() != UnitType.AIR) {

                if (targetPos.equals(enemyPos)) {
                    enemy.onAttacked(getAp());
                    continue;
                }

                if (targetPos.getDistance(enemyPos) < 2.0 - EPSILON) {
                    enemy.onAttacked((calculateAoeDamage(enemyPos)));
                }
            }
        }

        return getAttackIntent();
    }
    @Override
    public void onAttacked(int damage) {
        hp -= isSeigeMode ? damage * 2 : damage;
    }

    @Override
    public char getSymbol() {
        return UnitData.TANK.getMark();
    }


    @Override
    public boolean isVisible(Unit other) {
        return other.getUnitType() == UnitType.GROUND;
    }

    @Override
    public void getPriorityPos(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {

        priorities.clear();

        if (!isSeigeMode) {
            isSeigeMode = true;
            hasActed = true;
            return;
        }

        if (getEnemiesInAttackRange().isEmpty()) {
            return;
        }
        targetPos = getPriorityPosInAttack(sourceUnits, priorities);
    }



    @Override
    public int calculateAoeDamage(IntVector2D targetPos) {

        int damage;
        final int DISTANCE = 1;

        damage = (int) (getAp() * (1 - DISTANCE / (getAoe() + 1.0)));

        return damage;
    }

    @Override
    public void moveToTarget(IntVector2D targetPos) {

        if (!isSeigeMode) {
            isSeigeMode = true;
        }
    }

    @Override
    public void passThisTurn() {
        if (isSeigeMode) {
            isSeigeMode = false;
            return;
        }

        int currX = getPosition().getX();

        if (currX == 0xF) {
            wasMovingToLeft = true;
        } else if (currX == 0x0) {
            wasMovingToLeft = false;
        }

        if (wasMovingToLeft) {
            getPosition().setX(currX - 1);
        } else {
            getPosition().setX(currX + 1);
        }
    }


    @Override
    protected boolean isAttackable(Unit target) {
        int manhattanDistance = getPosition().getManhattanDistance(target.getPosition());
        int xDiff = Math.abs(getPosition().getX() - target.getPosition().getX());
        int yDiff = Math.abs(getPosition().getY() - target.getPosition().getY());

        return (manhattanDistance == 2 && (xDiff == 0 || yDiff == 0)) ||
                (manhattanDistance == 3 && (xDiff == 1 || yDiff == 1));
    }

}
