package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Marine extends ThinkableUnit implements IMovable {


    public Marine(IntVector2D currPos) {
        super(currPos, UnitData.MARINE.getHp(), UnitData.MARINE.getUnitType(),
                UnitData.MARINE.getSight(), UnitData.MARINE.getAoe(), UnitData.MARINE.getAp());
    }

    @Override
    public char getSymbol() {
        return UnitData.MARINE.getMark();
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
}
