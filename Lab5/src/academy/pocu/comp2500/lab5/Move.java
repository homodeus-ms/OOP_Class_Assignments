package academy.pocu.comp2500.lab5;

public class Move {
    private final String moveName;
    private final int movePower;
    private final int maxRemainMoveCount;
    private int currRemainMoveCount;

    public Move(String moveName, int movePower, int moveMaxCount) {
        this.moveName = moveName;
        this.movePower = movePower;
        this.maxRemainMoveCount = moveMaxCount;
        this.currRemainMoveCount = moveMaxCount;
    }

    public String getMoveName() {
        return moveName;
    }

    public int getMovePower() {
        return movePower;
    }

    public int getCurrRemainMoveCount() {
        return this.currRemainMoveCount;
    }
    public void recoverMoveCount() {
        if (currRemainMoveCount < maxRemainMoveCount) {
            ++this.currRemainMoveCount;
        }
    }
    public void decreaseCurrRemainMoveCount() {
        --currRemainMoveCount;
    }
}
