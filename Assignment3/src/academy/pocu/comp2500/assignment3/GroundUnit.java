package academy.pocu.comp2500.assignment3;

public abstract class GroundUnit extends Unit {

    protected GroundUnit(IntVector2D currPos, int hp, int sightRange, int aoe, int ap,
                         double attackRange) {
        super(currPos, hp, UnitType.GROUND, sightRange, aoe, ap);
    }
}
