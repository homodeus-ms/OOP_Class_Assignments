package academy.pocu.comp2500.lab5;

public class Move {
    private final String moveName;
    private final int movePower;
    private int maxMoveCount;

    public Move(String moveName, int movePower, int moveMaxCount) {
        this.moveName = moveName;
        this.movePower = movePower;
        this.maxMoveCount = moveMaxCount;
    }

    public String getMoveName() {
        return moveName;
    }

    public int getMovePower() {
        return movePower;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }
    public void recoverMoveCount() {
        ++this.maxMoveCount;
    }

}
