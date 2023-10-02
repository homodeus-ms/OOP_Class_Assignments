package academy.pocu.comp2500.lab5;

public class Move {
    private final String moveName;
    private final int movePower;
    private final int maxMoveCount;
    private int currMoveCount;

    public Move(String moveName, int movePower, int moveMaxCount) {
        this.moveName = moveName;
        this.movePower = movePower;
        this.maxMoveCount = moveMaxCount;
        this.currMoveCount = moveMaxCount;
    }

    public String getMoveName() {
        return moveName;
    }

    public int getMovePower() {
        return movePower;
    }

    public int getCurrMoveCount() {
        return this.currMoveCount;
    }
    public void recoverMoveCount() {
        if (currMoveCount < maxMoveCount) {
            ++this.currMoveCount;
        }
    }

}
