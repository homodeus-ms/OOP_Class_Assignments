package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class Marine extends AdjacentUnit {
    public Marine(IntVector2D currPos) {
        super(currPos, UnitData.MARINE.getHp(), UnitData.MARINE.getUnitType(),
                UnitData.MARINE.getSight(), UnitData.MARINE.getAoe(), UnitData.MARINE.getAp());
    }

    @Override
    public char getSymbol() {
        return UnitData.MARINE.getMark();
    }

}
