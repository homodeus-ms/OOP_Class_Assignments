package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Destroyer extends SelectiveAttackUnit {

    public Destroyer(IntVector2D currPos) {
        super(currPos, Integer.MAX_VALUE, UnitType.GROUND, 0x100, 0x10000, 0x10000);
    }

    @Override
    public char getSymbol() {
        return 'D';
    }
    @Override
    public AttackIntent attack() {

        for (Unit u : SimulationManager.getInstance().getUnits()) {
            if (this != u) {
                u.onAttacked(getAp());
            }
        }
        return getAttackIntent();
    }

    @Override
    public void onAttacked(int damage) {
        hp -= 1;
    }

    @Override
    public void findEnemiesInAttackRangeAndSightRange() {
        enemiesInSight.clear();
        enemiesInAttackRange.clear();

        enemiesInAttackRange.addAll(SimulationManager.getInstance().getUnits());
    }
    @Override
    public void getPriorityPos(ArrayList<Unit> sourceUnits, ArrayList<Unit> priorities) {
    }

    @Override
    public boolean isVisible(Unit enemy) {
        return true;
    }
    @Override
    protected boolean isEnemyInSight(Unit enemy) {
        return true;
    }

    @Override
    protected boolean isAttackable(Unit target) {
        return true;
    }
}
