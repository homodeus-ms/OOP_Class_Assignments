package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class Unit {

    protected final double EPSILON = 0.0001;
    private IntVector2D currPos;
    protected IntVector2D targetPosOrNull = new IntVector2D(-1, -1);
    protected boolean hasActed;

    protected int hp;
    private final UnitType unitType;
    private final int sight;

    private final int aoe;
    private final int ap;
    private AttackIntent attackIntent;

    protected ArrayList<Unit> enemiesInSight = new ArrayList<>();
    protected ArrayList<Unit> enemiesInAttackRange = new ArrayList<>();
    protected ArrayList<Unit> enemyPriorities = new ArrayList<>();

    protected Unit(IntVector2D currPos, final int hp, final UnitType unitType,
                   final int sight, final int aoe, final int ap) {
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

    public boolean hasActed() {
        return hasActed;
    }

    public IntVector2D getTargetPosOrNull() {
        return targetPosOrNull;
    }

    public ArrayList<Unit> getEnemiesInSight() {
        return enemiesInSight;
    }
    public ArrayList<Unit> getEnemiesInAttackRange() {
        return enemiesInAttackRange;
    }

    public AttackIntent getAttackIntent() {
        return attackIntent;
    }

    public ArrayList<Unit> getEnemyPriorities() {
        return enemyPriorities;
    }

    // 디폴트를 마린과 레이스의 경우로
    public AttackIntent attack() {

        makeAttackIntent();

        IntVector2D targetPos = attackIntent.getAttackPos();
        for (Unit u : SimulationManager.getInstance().getUnits()) {
            if (this != u && targetPos.equals(u.currPos)) {
                u.onAttacked(attackIntent.getDamage());
            }
        }
        return attackIntent;
    }

    // 적이 있는 쪽으로 이동. default는 move인데 움직이지 않음(?)
    /*public void moveToTarget(IntVector2D targetPos) {
    }*/
    // 시야 안에 적이 없을 때 각자의 행동을 하고 턴을 넘김.
    /*public void passThisTurn() {

    }*/

    // 탱크나 지뢰의 경우 지상유닛인지 체크해야 하니까 오버라이딩을 해야 함
    public void onAttacked(int damage) {
        hp -= damage;
        //hp = Math.max(0, hp);
    }

    public void onSpawn() {
        char symbol = this.getSymbol();

        if (symbol != 'N') {
            SimulationManager.getInstance().registerThinkable((IThinkable) this);
        }

        if (symbol == 'M' || symbol == 'W' || symbol == 'T') {
            SimulationManager.getInstance().registerMovable((IMovable) this);
        } else if (symbol == 'N' || symbol == 'A') {
            SimulationManager.getInstance().registerCollisionEventListener((ICollisionEventListener) this);
        }
    }

    // 이것도 역시 디폴트는 머린과 레이스, 나머지 유닛들은 각 클래스에서 오버라이드
    public boolean isVisible(Unit other) {
        return other.getUnitType() != UnitType.BURROWED;
    }

    public abstract char getSymbol();

    // thinkable 유닛들의 기본 동작임. mine만 따로 오버라이딩
    public void setEnemiesInAttackRangeAndSightRange() {
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

    public void goNextTurn() {
        hasActed = false;
    }

    protected boolean isEnemyInSight(Unit enemy) {
        int enemyX = enemy.getPosition().getX();
        int enemyY = enemy.getPosition().getY();

        return Math.abs(enemyX - currPos.getX()) <= this.sight &&
                Math.abs(enemyY - currPos.getY()) <= this.sight;
    }

    // Marine과 Wraith의 경우 override없이 이것을 default로 사용
    protected boolean isAttackable(Unit target) {
        return this.currPos.getDistance(target.currPos) <= 1.0 + EPSILON;
    }

    protected void makeAttackIntent() {
        if (this.attackIntent == null) {
            attackIntent = new AttackIntent(targetPosOrNull, ap, this);
        } else {
            attackIntent.setAttackIntent(targetPosOrNull, ap, this);
        }
    }
}