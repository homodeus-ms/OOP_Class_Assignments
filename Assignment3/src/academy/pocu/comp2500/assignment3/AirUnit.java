package academy.pocu.comp2500.assignment3;

public abstract class AirUnit extends Unit {

    protected AirUnit(IntVector2D currPos, int hp, int sightRange, int aoe, int ap,
                      double attackRange) {
        super(currPos, hp, UnitType.AIR, sightRange, aoe, ap);
    }
}
