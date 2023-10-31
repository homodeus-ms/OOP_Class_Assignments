package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Marine extends GroundUnit {


    public Marine(IntVector2D currPos) {
        super(currPos, UnitData.MARINE.getHp(), UnitData.MARINE.getSight(),
                UnitData.MARINE.getAoe(), UnitData.MARINE.getHp(), UnitData.MARINE.getAp());
    }
    @Override
    public AttackIntent attack() {
        return null;
    }
    @Override
    public char getSymbol() {
        return UnitData.MARINE.getMark();
    }

    @Override
    protected IntVector2D getNextPos(int searchCount, IntVector2D pos) {
        switch (searchCount) {
            case 0:    // same position
                break;
            case 1:    // north + 1
                pos.setY(pos.getY() - 1);
                break;
            case 2:    // east + 1
                pos.setX(pos.getX() + 1);
                pos.setY(pos.getY() + 1);
                break;
            case 3:    // south + 1
                pos.setX(pos.getX() - 1);
                pos.setY(pos.getY() + 1);
                break;
            case 4:    // west + 1
                pos.setX(pos.getX() - 1);
                pos.setY(pos.getY() - 1);
                break;
            default:
                assert (false);
                break;
        }

        return pos;
    }


    public void findEnemyInSight() {

    }


    private void Move() {

    }

}
