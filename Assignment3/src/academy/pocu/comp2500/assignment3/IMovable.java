package academy.pocu.comp2500.assignment3;

public interface IMovable {
    void moveToTarget(IntVector2D targetPos);

    // 시야안에 적이 없을 때 각자의 행동을 하고 턴을 넘김.
    void passThisTurn();
}
