package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Unit {

    private IntVector2D currPos;
    private int hp;
    private final UnitType unitType;
    private final int sight;

    private final int aoe;
    private final int ap;
    private AttackIntent attackIntent;

    private ArrayList<Unit> enemiesInSight = new ArrayList<>();
    private ArrayList<Unit> enemiesInAttackRange = new ArrayList<>();
    private ArrayList<Unit> priorities = new ArrayList<>();

    protected Unit(IntVector2D currPos, int hp, UnitType unitType, int sight,
                   int aoe, int ap) {
        this.currPos = currPos;
        this.hp = hp;
        this.unitType = unitType;
        this.sight = sight;
        this.aoe = aoe;
        this.ap = ap;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public int getSightRange() {
        return sight;
    }

    public int getAoe() {
        return aoe;
    }

    public int getAp() {
        return ap;
    }

    public IntVector2D getPosition() {
        return currPos;
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Unit> getEnemiesInSight() {
        return enemiesInSight;
    }


    public AttackIntent attack() {
        return attackIntent;
    }

    public void onAttacked(int damage) {
        hp -= damage;
    }

    public void onSpawn() {

    }

    public abstract char getSymbol();




    protected void findMinHpEnemies() {
        ArrayList<Unit> spawnedUnits = SimulationManager.getInstance().getUnits();
        if (spawnedUnits.isEmpty()) {
            return;
        }

        int minHp = 0;

        for (Unit u : spawnedUnits) {
            if (isAttackable(u)) {
                if (enemiesInAttackRange.isEmpty() || u.getHp() < minHp) {
                    minHp = u.getHp();
                    enemiesInAttackRange.clear();
                    enemiesInAttackRange.add(u);
                } else if (u.getHp() == minHp) {
                    enemiesInAttackRange.add(u);
                }
            }
        }

        if (enemiesInAttackRange.size() > 1) {
            IntVector2D = findPriorityDirection(enemiesInAttackRange, getMaxDirectionCount)
            return;
        }

        minHp = 0;

        for (Unit u : spawnedUnits) {
            if (isEnemyInSight(u)) {
                if (enemiesInSight.isEmpty() || u.getHp() < minHp) {
                    minHp = u.getHp();
                    enemiesInSight.clear();
                    enemiesInSight.add(u);
                } else if (u.getHp() == minHp) {
                    enemiesInSight.add(u);
                }
            }
        }

        assert (!enemiesInAttackRange.isEmpty() || enemiesInSight.isEmpty());
    }



    private IntVector2D findPriorityDirection(ArrayList<Unit> enemies, int maxDirectionCount) {
        IntVector2D pos = new IntVector2D(this.currPos.getX(), this.currPos.getY());

        int size = enemies.size();
        int searchCount = 0;    // 0:samePos, 1:north... 4:west, 4 is Max in case of Marine

        for (int i = 0; i <= maxDirectionCount; ++ i) {
            pos = getNextPos(i, pos);
            for (int j = 0; j < size; ++j) {
                if (enemies.get(j).currPos == pos) {
                    return pos;
                }
            }
        }

        assert (false) : "It should be returned in previous loop";
        return null;
    }


    protected abstract IntVector2D getNextPos(int searchCount, IntVector2D pos);

    protected boolean isEnemyInSight(Unit enemy) {
        double distance = getDistance(enemy);
        return distance <= Math.sqrt(2 * sight * sight);
    }

    // Marine과 Wraith의 경우 override없이 이것을 default로 사용
    protected boolean isAttackable(Unit target) {
        return this.currPos.getDistance(target.currPos) <= 1.0;
    }

    private double getDistance(Unit other) {
        return Math.sqrt(Math.pow((this.currPos.getX() - other.currPos.getX()), 2) +
                Math.pow((this.currPos.getY() - other.currPos.getY()), 2));
    }
    private int getManhattanDistance(Unit other) {
        return Math.abs(this.currPos.getX() - other.currPos.getX()) +
                Math.abs(this.currPos.getY() - other.currPos.getY());
    }


}