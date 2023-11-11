package academy.pocu.comp2500.assignment3;

public abstract class AdjacentUnit extends SelectiveAttackUnit implements IMovable {

    // 머린과 레이스처럼 인접한 타일만을 공격할 수 있는 유닛
    protected AdjacentUnit(IntVector2D currPos, int hp, final UnitType unitType,
                           final int sightRange, final int aoe, final int ap) {
        super(currPos, hp, unitType, sightRange, aoe, ap);
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
            } else if (x > targetX) {
                getPosition().setX(x - 1);
            }
        } else if (y < targetY) {
            getPosition().setY(y + 1);
        } else {
            getPosition().setY(y - 1);
        }
    }

    // 머린의 기본 동작, 레이스는 밑에서 오버라이드 할 것임
    @Override
    public void passThisTurn() {

    }
}
